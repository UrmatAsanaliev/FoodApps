package com.example.foodapps.ui.fragment.main.adapter.pager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapps.R
import com.example.foodapps.databinding.ItemPagerBinding

class PagerAdapter() : RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {

    private val list = listOf(
        R.drawable.img_1,
        R.drawable.img_1,
        R.drawable.img_1,
        R.drawable.img_1,
        R.drawable.img_1,
        R.drawable.img_1,
        R.drawable.img_1
    )

    inner class PagerViewHolder(private val binding: ItemPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Int) {
            binding.imgPager.setImageResource(model)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(
            ItemPagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(list[position])
    }
}