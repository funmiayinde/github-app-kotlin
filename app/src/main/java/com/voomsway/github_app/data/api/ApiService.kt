package com.voomsway.github_app.data.api

import com.voomsway.github_app.data.model.GithubUser
import io.reactivex.Flowable

/**
 * Created by funmi ayinde on 16/03/2020.
 */
interface ApiService {

    fun getGithubUsers(): Flowable<List<GithubUser>>
}
