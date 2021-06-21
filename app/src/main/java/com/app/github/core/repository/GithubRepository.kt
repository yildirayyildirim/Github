package com.app.github.core.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository
@Inject
constructor(private val apiService: IGithubService) {

    suspend fun getGithubInformationByUsername(id: String) =
        apiService.getGithubInformationByUsername(id)
}