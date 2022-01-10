package com.uraniumcode.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.uraniumcode.kotlincountries.R
import com.uraniumcode.kotlincountries.model.Country
import com.uraniumcode.kotlincountries.util.downloadFromUrl
import com.uraniumcode.kotlincountries.util.placeholderProgressBar
import com.uraniumcode.kotlincountries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter (val countryList: ArrayList<Country>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){


    class CountryViewHolder(var view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
            val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.nameTv.text=countryList[position].countryName
        holder.view.regionTv.text=countryList[position].countryRegion

        holder.view.setOnClickListener{
            val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }
        holder.view.imageView.downloadFromUrl(countryList[position].imageUrl, placeholderProgressBar(holder.view.context))

    }

    override fun getItemCount(): Int {
       return countryList.size
    }

    fun updateCountryList(newCountryList:List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }


}