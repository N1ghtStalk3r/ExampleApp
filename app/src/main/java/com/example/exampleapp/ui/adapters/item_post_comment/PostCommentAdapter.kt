package com.example.exampleapp.ui.adapters.item_post_comment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.R
import com.example.exampleapp.databinding.ItemPostCommentBinding
import com.example.exampleapp.ui.dto.PostCommentItem

// Адаптер для комментария поста (три поля)
class PostCommentAdapter(
    val postComments: MutableList<PostCommentItem>
) : RecyclerView.Adapter<PostCommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostCommentViewHolder =
        PostCommentViewHolder(
            ItemPostCommentBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_post_comment, parent, false)
            )
        )

    override fun onBindViewHolder(holder: PostCommentViewHolder, position: Int) {
        holder.itemBinding.commentName.text = postComments[position].name
        holder.itemBinding.commentEmail.text = postComments[position].email
        holder.itemBinding.commentBody.text = postComments[position].body
    }

    override fun getItemCount() = postComments.size
}