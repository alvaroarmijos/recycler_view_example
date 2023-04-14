package com.example.recyclerviewexamplw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexamplw.adapter.SuperHeroAdapter
import com.example.recyclerviewexamplw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var superHeroMutableList: MutableList<SuperHero> =
        SuperHeroProvider.shuperHeroList.toMutableList()
    private lateinit var adapter: SuperHeroAdapter
    private val llManager = LinearLayoutManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddSuperhero.setOnClickListener { createSuperHero() }
        initRecyclerView()
    }

    private fun createSuperHero() {
        val superHero = SuperHero(
            "Incognito",
            "Alvaro",
            "???????",
            "https://pbs.twimg.com/media/DORGTXaWAAE6eNu.jpg"
        )

        superHeroMutableList.add(index = 3, superHero)
        adapter.notifyItemInserted(3)
        llManager.scrollToPositionWithOffset(3, 10)
    }

    private fun initRecyclerView() {
        adapter = SuperHeroAdapter(
            superHeroList = superHeroMutableList,
            onClickListener = { onItemSelected(it) },
            onClickDelete = { position -> onDeleteItem(position) }
        )
        binding.recyclerSuperHero.layoutManager = llManager
        binding.recyclerSuperHero.adapter = adapter
    }

    private fun onDeleteItem(position: Int) {
        superHeroMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    private fun onItemSelected(superHero: SuperHero) {
        Toast.makeText(this, superHero.superHero, Toast.LENGTH_SHORT).show()
    }
}