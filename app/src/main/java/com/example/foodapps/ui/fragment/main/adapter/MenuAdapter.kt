package com.example.foodapps.ui.fragment.main.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapps.R
import com.example.foodapps.databinding.ItemMenuBinding

class MenuAdapter(
    private val click: Result
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    private val list = listOf(
        "breads",
        "burgers",
        "chocolates",
        "desserts",
        "drinks",
        "fried_chicken",
        "ice_cream",
        "pizzas",
        "porks",
    )

    inner class MenuViewHolder(val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: String) {
            binding.tvMenu.text = model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder =
        MenuViewHolder(
            ItemMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: MenuViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(list[position])
        if (position == selectedPosition) {
            holder.binding.cardView.setCardBackgroundColor(Color.RED)
        } else {
            holder.binding.cardView.setCardBackgroundColor(Color.WHITE)
        }
        holder.itemView.setOnClickListener {
            click.setMenu(list[position])
            selectedPosition = position
            notifyDataSetChanged()
        }
    }

    interface Result {
        fun setMenu(menu: String)
    }
}