package com.example.exampleapp.ui.adapters.item_post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.R
import com.example.exampleapp.databinding.ItemPostBinding
import com.example.exampleapp.ui.dto.PostListItem

// Адаптер для поста (только заголовок)
class PostItemAdapter(
    val posts: MutableList<PostListItem>,
    private val onItemClicked: (postId: Int) -> Unit = {}
) : RecyclerView.Adapter<PostItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder =
        PostItemViewHolder(
            ItemPostBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_post, parent, false)
            )
        )

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        holder.itemBinding.tvTitle.text = posts[position].title
        holder.itemBinding.root.setOnClickListener {
            onItemClicked(posts[position].id)
        }
    }

    override fun getItemCount(): Int = posts.size
}