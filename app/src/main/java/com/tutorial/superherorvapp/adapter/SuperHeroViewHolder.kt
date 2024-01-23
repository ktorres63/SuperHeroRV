package com.tutorial.superherorvapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tutorial.superherorvapp.R
import com.tutorial.superherorvapp.SuperHero
import com.tutorial.superherorvapp.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)

     private val photo = binding.ivSuperHero

    fun render(superHeroModel: SuperHero, onClickListener: (SuperHero) -> Unit) {
        binding.tvSuperHeroName.text = superHeroModel.superhero
        binding.tvRealName.text = superHeroModel.realName
        binding.tvPublisher.text = superHeroModel.publisher
        Glide.with(photo.context).load(superHeroModel.photo).into(photo)


        itemView.setOnClickListener {
            onClickListener(superHeroModel)
        }

        //        binding.ivSuperHero.setOnClickListener {
//            Toast.makeText(
//                photo.context, superHeroModel.realName, Toast.LENGTH_SHORT
//            ).show()
//        }
    }
}