package com.voomsway.github_app.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by funmi ayinde on 17/03/2020.
 */
data class GithubUsers(
    @SerializedName("total_count")
    val total_count: Int = 0,
    @SerializedName("incomplete_results")
    val incomplete_results: Boolean,
    @SerializedName("items")
    val items: List<Items>
)