package com.uraniumcode.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.uraniumcode.kotlincountries.R
import com.uraniumcode.kotlincountries.adapter.CountryAdapter
import com.uraniumcode.kotlincountries.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

    private lateinit var viewModel:FeedViewModel
    private val countryAdapter=CountryAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()
        countryListRec.layoutManager=LinearLayoutManager(context)
        countryListRec.adapter=countryAdapter

            observeLiveData()

        swipeRefreshLayout.setOnRefreshListener {
            countryListRec.visibility=View.GONE
            countryError.visibility=View.GONE
            countryLoading.visibility=View.VISIBLE
            viewModel.refreshData()
            swipeRefreshLayout.isRefreshing=false
        }
      /*  to_countrybtn.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
        Navigation.findNavController(it).navigate(action)
        }*/
    }

    private fun observeLiveData(){
        viewModel.countries.observe(viewLifecycleOwner, Observer{countries->
            countries?.let{
                countryListRec.visibility=View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        })
         viewModel.countryError.observe(viewLifecycleOwner, Observer { error->
             error?.let{
                 if(it){
                     countryError.visibility=View.VISIBLE
                 }else{
                     countryError.visibility=View.GONE
                 }
             }
         })
        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let {
                if(it){
                    countryLoading.visibility=View.VISIBLE
                    countryListRec.visibility=View.GONE
                    countryError.visibility=View.GONE
                }else{
                    countryLoading.visibility=View.GONE
                }
            }
        })

    }


}