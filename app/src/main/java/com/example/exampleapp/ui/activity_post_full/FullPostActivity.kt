package com.example.exampleapp.ui.activity_post_full

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.exampleapp.R
import com.example.exampleapp.data.ConstantsProvider
import com.example.exampleapp.data.ConstantsProvider.Companion.POST_ID_ARG
import com.example.exampleapp.data.ConstantsProvider.Companion.makeToast
import com.example.exampleapp.data.net.HttpClientProvider
import com.example.exampleapp.databinding.ActivityFullPostBinding
import com.example.exampleapp.domain.dto.Post
import com.example.exampleapp.domain.dto.PostComment
import com.example.exampleapp.domain.dto.User
import com.example.exampleapp.ui.adapters.item_post_comment.PostCommentAdapter
import com.example.exampleapp.ui.adapters.item_post_full.FullPostItemAdapter
import com.example.exampleapp.ui.dto.PostCommentItem
import com.example.exampleapp.ui.post_comment.PostCommentsViewModel
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Экран для отображения полного поста с комментариями
 */
class FullPostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullPostBinding
    private lateinit var adapter: FullPostItemAdapter
    private lateinit var commentsAdapter: PostCommentAdapter

    private lateinit var client: HttpClientProvider

    private val postCommentViewModel by viewModel<PostCommentsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        client = HttpClientProvider(ConstantsProvider())


        val postId = intent.getIntExtra(POST_ID_ARG, -1)

        if (postId != -1) {
            lifecycleScope.launchWhenCreated {
                postCommentViewModel.init()
                try {
                    val post: Post = client.getHttpClient().get("posts/$postId")
                    val postComment: MutableList<PostCommentItem> = client.getHttpClient().get("comments?postId=${postId}")
                    val user: User = client.getHttpClient().get("users/${post.userId}")

                    commentsAdapter = PostCommentAdapter(postComment)

                    adapter = FullPostItemAdapter(postComment, post, user)



//                    binding.rvPostData.adapter = adapter

                    binding.rvPostData.adapter = commentsAdapter
                } catch (e: Throwable) {
                    toast()
                }
            }
        } else {
            toast()
        }
    }

    fun toast() {
        makeToast(applicationContext, R.string.loading_error_happened)
    }
}