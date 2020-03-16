package com.voomsway.github_app.data.repository

import com.voomsway.github_app.data.api.ApiHelper
import com.voomsway.github_app.data.model.GithubUser
import io.reactivex.Flowable

/**
 * Created by funmi ayinde on 16/03/2020.
 */
class MainRepository(private val apiHelper: ApiHelper) {

    fun getGithubUser(): Flowable<List<GithubUser>> {
        return apiHelper.getGithubUsers();
    }
}