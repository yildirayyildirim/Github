package com.app.github.presentation.view.fragment

import android.view.View
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.github.R
import com.app.github.core.base.BaseFragment
import com.app.github.databinding.ViewFragmentHomeBinding
import com.app.github.presentation.view.adapter.MainAdapter
import com.app.github.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class HomeFragment : BaseFragment<ViewFragmentHomeBinding, HomeViewModel>() {
    private lateinit var mainAdapter: MainAdapter

    override fun getContentView(): Int {
        return R.layout.view_fragment_home
    }

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun subScribe(view: View) {
        super.subScribe(view)

        init()

        baseViewModel.resultModel.observe(viewLifecycleOwner, {
            it.let {
                mainAdapter.updateList(it)
            }

        })

    }

    private fun init() {
        mainAdapter = MainAdapter(requireContext())
        dataBinding.mainRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = mainAdapter
        }

        dataBinding.idSearch.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
                private var searchJob: Job? = null

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText.let {
                        if (it!!.length > 2) {
                            searchJob?.cancel()
                            searchJob = coroutineScope.launch {
                                newText?.let {
                                    delay(1000)
                                    baseViewModel.getGithubInformationByUsername(newText);
                                }
                            }
                        } else {
                            showMessageBox(getString(R.string.EnAzIkiHarfGiriniz))
                        }
                    }


                    return false
                }
            })
    }
}