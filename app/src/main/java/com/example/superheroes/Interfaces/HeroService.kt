package com.example.superheroes.Interfaces

import com.example.superheroes.Pojos.Heroes
import retrofit2.Call
import retrofit2.http.GET

interface HeroService {
    //https://thesimplycoder.herokuapp.com/marvel-heroes
    @GET("marvel-heroes")
    fun getHeroes(): Call<Heroes>

    /*@GET
    fun getHeroes(@Url url: String): Response<List<Heroes>>*/
}