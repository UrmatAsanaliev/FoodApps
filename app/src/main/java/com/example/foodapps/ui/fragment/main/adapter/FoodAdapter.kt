package com.example.foodapps.ui.fragment.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodapps.core.loadImage
import com.example.foodapps.domain.model.FoodModel
import com.example.foodapps.databinding.ItemFoodBinding

class FoodAdapter : Adapter<FoodAdapter.FoodViewHolder>() {

    private val list = ArrayList<FoodModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<FoodModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(private val binding: ItemFoodBinding) :
        ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(model: FoodModel) {
            binding.imgFood.loadImage(model.img!!)
            binding.tvName.text = model.name
            binding.tvDesc.text = model.dsc
            binding.btnPrice.text = "${model.price}$"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder =
        FoodViewHolder(
            ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(list[position])
    }
}