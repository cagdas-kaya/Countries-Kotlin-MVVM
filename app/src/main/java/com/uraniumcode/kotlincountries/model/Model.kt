package com.uraniumcode.kotlincountries.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("region")
    val countryCapital: String?,
    @SerializedName("capital")
    val countryRegion: String?,
    @SerializedName("currency")
    val countryCurrency: String?,
    @SerializedName("language")
    val countryLanguage: String?,
    @SerializedName("flag")
    val imageUrl: String?,

)