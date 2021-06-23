package com.app.github.presentation.view.fragment

import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.app.github.R
import com.app.github.core.base.BaseFragment
import com.app.github.core.persistence.entity.BookmarkEntity
import com.app.github.databinding.ViewFragmentDetailBinding
import com.app.github.presentation.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<ViewFragmentDetailBinding, DetailViewModel>() {
    private val args: DetailFragmentArgs by navArgs()
    private var isFavorite: Boolean = false

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
        baseViewModel.load(args.model.id)
        baseViewModel.bookmarkEntity.observe(viewLifecycleOwner, {
            isFavorite = false
            it?.let {
                isFavorite = true
            }
            dataBinding.isFavorite =isFavorite
        })

        dataBinding.imgBack.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }

        dataBinding.imgStars.setOnClickListener {
            baseViewModel.insertAndRemove(
                isFavorite,
                BookmarkEntity(
                    args.model.id,
                    args.model.owner.avatar_url,
                    args.model.name,
                    args.model.description,
                    args.model.stargazers_count,
                    args.model.owner.login,
                    "0"
                )
            )
        }
    }
}