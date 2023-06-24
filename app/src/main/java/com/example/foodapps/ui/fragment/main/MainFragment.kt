package com.example.foodapps.ui.fragment.main

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.foodapps.core.base.BaseFragment
import com.example.foodapps.core.gone
import com.example.foodapps.core.visible
import com.example.foodapps.core.UIState
import com.example.foodapps.databinding.FragmentMainBinding
import com.example.foodapps.domain.model.FoodModel
import com.example.foodapps.ui.fragment.main.adapter.FoodAdapter
import com.example.foodapps.ui.fragment.main.adapter.MenuAdapter
import com.example.foodapps.ui.fragment.main.adapter.pager.NextItemTransformer
import com.example.foodapps.ui.fragment.main.adapter.pager.PagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate), MenuAdapter.Result {

    private val viewModel: MainViewModel by viewModels()
    private val menuAdapter: MenuAdapter by lazy { MenuAdapter(this) }
    private val foodAdapter: FoodAdapter by lazy { FoodAdapter() }
    private val pagerAdapter: PagerAdapter by lazy { PagerAdapter() }

    override fun setupUI() {
        initViewModel()
        initAdapters()
    }

    private fun initViewModel() {
        viewModel.getFood("breads")
    }

    private fun isError(error: String) {
        requireBinding().rvFood.gone()
        requireBinding().progress.gone()
        requireBinding().tvError.visible()
        requireBinding().tvError.text = error
    }

    override fun setupObservers() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getFood.collect {
                    when (it) {
                        is UIState.Error -> isError(it.error)
                        is UIState.Loading -> isLoading()
                        is UIState.Success -> isSuccess(it.data)
                    }
                }
            }
        }
    }

    private fun isSuccess(data: List<FoodModel>) {
        requireBinding().rvFood.visible()
        requireBinding().tvError.gone()
        requireBinding().progress.gone()
        foodAdapter.setList(data)
    }

    private fun isLoading() {
        requireBinding().rvFood.gone()
        requireBinding().tvError.gone()
        requireBinding().progress.visible()
    }

    private fun initAdapters() {
        requireBinding().rvFood.adapter = foodAdapter
        requireBinding().rvMenu.adapter = menuAdapter
        requireBinding().vpItems.adapter = pagerAdapter
        requireBinding().vpItems.offscreenPageLimit = 2
        requireBinding().vpItems.setPageTransformer(NextItemTransformer())
    }

    override fun setMenu(menu: String) {
        viewModel.getFood(menu)
    }
}