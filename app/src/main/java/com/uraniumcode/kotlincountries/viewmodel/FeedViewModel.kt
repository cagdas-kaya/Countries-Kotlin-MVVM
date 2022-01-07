package com.uraniumcode.kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uraniumcode.kotlincountries.model.Country

class FeedViewModel:ViewModel() {
    val countries=MutableLiveData<List<Country>>()
    val countryError=MutableLiveData<Boolean>()
    val countryLoading=MutableLiveData<Boolean>()

    fun refreshData(){
        val country=Country("Turkey","Ankara","Asia","TRY","Turkish","www.com")
        val country2=Country("France","Paris","Europe","Eur","French","www.com")
        val country3=Country("Germany","Berlin","Europe","Eur","German","www.com")
        val countryList= arrayListOf<Country>(country,country2,country3)

        countries.value=countryList
        countryError.value=false
        countryLoading.value=false
    }
}