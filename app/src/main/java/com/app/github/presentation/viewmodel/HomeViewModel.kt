package com.app.github.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.github.core.base.BaseViewModel
import com.app.github.core.repository.GithubRepository
import com.app.github.presentation.model.GithubModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(private val repository: GithubRepository) : BaseViewModel() {

    val resultModel = MutableLiveData<GithubModel>()

    init {
        getAllDiscover()
    }

    private fun getAllDiscover() =
        viewModelScope.launch {
            getIsLoading().postValue(true)
            repository.getGithubInformationByUsername("yildirayyildirim")
                .let { response ->
                    if (response.isSuccessful) {
                        resultModel.postValue(response.body())
                    }
                    getIsLoading().value = false
                }
        }
}