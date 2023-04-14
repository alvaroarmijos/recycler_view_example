package com.example.recyclerviewexamplw.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewexamplw.SuperHero
import com.example.recyclerviewexamplw.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun render(
        superHeroModel: SuperHero,
        onClickListener: (SuperHero) -> Unit,
        onClickDelete: (Int) -> Unit
    ) {
        binding.tvSuperHeroName.text = superHeroModel.superHero
        binding.tvRealName.text = superHeroModel.realName
        binding.tvPublisher.text = superHeroModel.publisher
        Glide.with(binding.ivSuperHero.context).load(superHeroModel.photo)
            .centerCrop()
            .into(binding.ivSuperHero)

        itemView.setOnClickListener {
            onClickListener(superHeroModel)
        }

        binding.btnDelete.setOnClickListener { onClickDelete(adapterPosition) }
    }
}