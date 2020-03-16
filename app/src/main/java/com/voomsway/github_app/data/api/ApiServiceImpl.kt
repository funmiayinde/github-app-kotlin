package com.voomsway.github_app.data.api

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.voomsway.github_app.data.model.GithubUsers
import com.voomsway.github_app.data.model.Items
import io.reactivex.Flowable

/**
 * Created by funmi ayinde on 16/03/2020.
 */
class ApiServiceImpl: ApiService {

    override fun getGithubUsers(): Flowable<GithubUsers> {
        return Rx2AndroidNetworking.get("https://api.github.com/search/repositories?q=android+language:java+language:kotlin&sort=stars&order=desc")
            .build()
            .getObjectFlowable(GithubUsers::class.java)
    }
}