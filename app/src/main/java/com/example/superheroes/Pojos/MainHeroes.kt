package com.example.superheroes.Pojos

import com.google.gson.annotations.SerializedName

//https://cursokotlin.com/tutorial-retrofit-2-en-kotlin-con-corrutinas-consumiendo-api-capitulo-20-v2/

data class MainHeroes(
    var _id: String,
    val superhero_name: String,
    val photo: String,
    val name: String
)
