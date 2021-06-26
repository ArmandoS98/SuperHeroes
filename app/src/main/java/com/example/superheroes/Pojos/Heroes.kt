package com.example.superheroes.Pojos

import com.google.gson.annotations.SerializedName

//https://cursokotlin.com/tutorial-retrofit-2-en-kotlin-con-corrutinas-consumiendo-api-capitulo-20-v2/

data class Heroes(
    @SerializedName("code") var code: Int,
    @SerializedName("data") val data :List<MainHeroes>
)
