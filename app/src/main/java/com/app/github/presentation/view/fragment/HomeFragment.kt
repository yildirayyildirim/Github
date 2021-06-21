package com.app.github.presentation.view.fragment

import android.view.View
import com.app.github.R
import com.app.github.core.base.BaseFragment
import com.app.github.databinding.ViewFragmentHomeBinding
import com.app.github.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<ViewFragmentHomeBinding, HomeViewModel>() {

    override fun getContentView(): Int {
        return R.layout.view_fragment_home
    }

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun subScribe(view: View) {
        super.subScribe(view)

        baseViewModel.resultModel.observe(viewLifecycleOwner, {
            it.let {
                println(it.size)
            }

        })

    }
}