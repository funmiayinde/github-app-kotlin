package com.voomsway.github_app.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.voomsway.github_app.R
import com.voomsway.github_app.data.model.GithubUser
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * Created by funmi ayinde on 16/03/2020.
 */
class MainAdapter(private val users: ArrayList<GithubUser>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: GithubUser) {
            itemView.authorName.text = user.name;
            itemView.repoName.text = user.full_name;
            itemView.starCount.text = user.stargazers_count.toString()
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar_url)
                .into(itemView.imageViewAvatar)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        )

    override fun getItemCount(): Int = users.size;

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<GithubUser>) {
        users.addAll(list);
    }
}