package com.example.foodapps.ui.fragment.main.adapter.pager

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class NextItemTransformer : ViewPager2.PageTransformer {

    private val nextItemOffset: Float = 20f

    override fun transformPage(page: View, position: Float) {
        page.translationX = page.width * -position

        if (position > 0) {
            page.translationX = nextItemOffset * position
        }
    }
}