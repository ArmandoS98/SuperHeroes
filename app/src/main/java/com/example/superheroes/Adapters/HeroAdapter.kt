package com.example.superheroes.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.superheroes.Pojos.MainHeroes
import com.example.superheroes.R
import kotlinx.android.synthetic.main.item_card.view.*

private const val TAG = "HeroAdapter"

class HeroAdapter(private val contexto: Context) :
    RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
    var movieList: List<MainHeroes> = listOf()

    fun setSuperHeroes(movieList: List<MainHeroes>) {
        this.movieList = movieList;
        notifyDataSetChanged()
    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachRoot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.item_card, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_name.text = movieList[position].name
        holder.itemView.tv_SuperheroName.text = movieList[position].superhero_name

        Glide.with(contexto)
            .load(movieList[position].photo)
            .into(holder.itemView.product_image)
    }

    override fun getItemCount() = movieList.size

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.d(TAG, "onClick: Ejecutandose")
        }

        companion object {
            private val PHOTO_KEY = "KEY"
        }

    }

}