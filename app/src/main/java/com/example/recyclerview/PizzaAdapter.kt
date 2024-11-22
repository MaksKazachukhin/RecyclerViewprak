package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.databinding.FragmentMainBinding
import com.example.recyclerview.databinding.ItemPizzaBinding

private var Pizzas = arrayListOf<Pizza>()

class PizzaAdapter(var Pizzas: ArrayList<Pizza>) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {


    inner class PizzaViewHolder(val binding: ItemPizzaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: Pizza) {
            binding.textView.text = pizza.name
            Glide.with(binding.imageView).load(pizza.image).into(binding.imageView)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(
            ItemPizzaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return Pizzas.size

    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(Pizzas[position])
    }
}

