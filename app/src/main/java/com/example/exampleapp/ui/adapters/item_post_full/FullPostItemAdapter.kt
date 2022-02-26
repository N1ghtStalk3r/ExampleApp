package com.example.exampleapp.ui.adapters.item_post_full

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.R
import com.example.exampleapp.databinding.ItemFullPostBinding
import com.example.exampleapp.domain.dto.Post
import com.example.exampleapp.domain.dto.User
import com.example.exampleapp.ui.adapters.item_post_comment.PostCommentAdapter
import com.example.exampleapp.ui.dto.PostCommentItem

class FullPostItemAdapter
    (
    // Комментарии
    private val postComments: MutableList<PostCommentItem>,
    // Один пост
    private val post: Post,
    // Автор поста
    private val user: User
) : RecyclerView.Adapter<FullPostItemViewHolder>() {

    private val postCommAdapter = PostCommentAdapter(postComments)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FullPostItemViewHolder =
        FullPostItemViewHolder(
            ItemFullPostBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_full_post, parent, false)
            )
        )

    override fun onBindViewHolder(holder: FullPostItemViewHolder, position: Int) {
        // Инфо поста
        holder.itemBinding.tvTitle.text = post.title
        holder.itemBinding.tvPostBody.text = post.body
        // Инфо автора
        holder.itemBinding.tvAuthor.text = user.name
        holder.itemBinding.tvEmail.text = user.email
        // Комментарии к посту
        holder.itemBinding.rvPostComments.adapter = postCommAdapter
    }

    override fun getItemCount() = postComments.size

}