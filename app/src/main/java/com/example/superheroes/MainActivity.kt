package com.example.superheroes

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroes.Adapters.HeroAdapter
import com.example.superheroes.Interfaces.HeroService
import com.example.superheroes.Pojos.Heroes
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerAdapter = HeroAdapter(this)
        recycle.layoutManager = GridLayoutManager(
            this,
            2,
            RecyclerView.VERTICAL,
            false
        )
        recycle.adapter = recyclerAdapter


        val retrofit = Retrofit.Builder()
            .baseUrl("https://thesimplycoder.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(HeroService::class.java)
        val call = service.getHeroes()

        call.enqueue(object : Callback<Heroes> {
            override fun onResponse(
                call: Call<Heroes>,
                response: Response<Heroes>
            ) {
                if (response.code() == 200 && response.isSuccessful) {
                    val mHeroes = response.body()!!
                    val listado = mHeroes.data
                    recyclerAdapter.setSuperHeroes(listado)
                    
                }
            }

            override fun onFailure(call: Call<Heroes>, t: Throwable) {
                Log.e(TAG, "onFailure: " + t.message)
            }

        })
    }
}