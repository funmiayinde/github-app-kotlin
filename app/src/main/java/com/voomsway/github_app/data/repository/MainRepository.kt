package com.voomsway.github_app.data.repository

import com.voomsway.github_app.data.api.ApiHelper
import com.voomsway.github_app.data.model.GithubUsers
import com.voomsway.github_app.data.model.Items
import io.reactivex.Flowable

/**
 * Created by funmi ayinde on 16/03/2020.
 */
class MainRepository(private val apiHelper: ApiHelper) {

    fun getGithubUser(): Flowable<GithubUsers> {
        return apiHelper.getGithubUsers();
    }
}