package com.app.github.presentation.view.fragment

import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.app.github.R
import com.app.github.core.base.BaseFragment
import com.app.github.databinding.ViewFragmentDetailBinding
import com.app.github.presentation.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<ViewFragmentDetailBinding, DetailViewModel>() {
    private val args: DetailFragmentArgs by navArgs()

    override fun getContentView(): Int {
        return R.layout.view_fragment_detail
    }

    override fun getViewModel(): Class<DetailViewModel> {
        return DetailViewModel::class.java
    }

    override fun subScribe(view: View) {
        super.subScribe(view)
        init()
        dataBinding.detailModel = args.model
    }

    private fun init() {
        dataBinding.imgBack.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}