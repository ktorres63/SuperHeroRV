package com.tutorial.superherorvapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.superherorvapp.adapter.SuperHeroAdapter
import com.tutorial.superherorvapp.adapter.SuperHeroViewHolder
import com.tutorial.superherorvapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
//        val manager = GridLayoutManager(this,3)

        val decoration = DividerItemDecoration(this,manager.orientation )
        binding.rvSuperHeroes.layoutManager = manager
        binding.rvSuperHeroes.adapter =
            SuperHeroAdapter(SuperHeroProvider.superheroList) { superhero ->
                onItemSelected(
                    superhero
                )
            }
        binding.rvSuperHeroes.addItemDecoration(decoration)

    }

    fun onItemSelected(superHero: SuperHero) {
        Toast.makeText(
                this, superHero.realName, Toast.LENGTH_SHORT
            ).show()

    }
}