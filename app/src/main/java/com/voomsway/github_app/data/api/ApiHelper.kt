package com.voomsway.github_app.data.api

/**
 * Created by funmi ayinde on 16/03/2020.
 */
class ApiHelper(private val apiService: ApiService) {

    fun getGithubUsers() = apiService.getGithubUsers()

}