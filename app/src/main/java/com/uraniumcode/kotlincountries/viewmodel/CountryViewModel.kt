package com.uraniumcode.kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uraniumcode.kotlincountries.model.Country

class CountryViewModel : ViewModel() {
    val countryLiveData=MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country=Country("Turkey","Ankara","Asia","TRY","Turkish","asd")
        countryLiveData.value=country
    }
}