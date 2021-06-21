package com.app.github.core.repository

import com.app.github.presentation.model.GithubModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IGithubService {

    /**
     * @return the GithubModel at the specified URL
     * @see Object
     */
    @GET("users/{user}/repos")
    suspend fun getGithubInformationByUsername(
        @Path("user") limit: String?,
    ): Response<GithubModel>
}