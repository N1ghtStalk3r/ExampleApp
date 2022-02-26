package com.example.exampleapp.ui.activity_posts_list

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.R
import com.example.exampleapp.data.ConstantsProvider.Companion.POST_ID_ARG
import com.example.exampleapp.databinding.ActivityMainBinding
import com.example.exampleapp.ui.adapters.item_post.PostItemAdapter
import com.example.exampleapp.ui.dto.PostListItem
import com.example.exampleapp.ui.activity_post_full.FullPostActivity
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Экран для отображения всех постов
 */
class PostsListActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostItemAdapter

    private val postsViewModel by viewModel<PostsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PostItemAdapter(mutableListOf()){ postId ->
            onPostClick(postId)
        }
        binding.rvPosts.adapter = adapter
        setDecorator()
        initObservers()

        lifecycleScope.launchWhenCreated {
            postsViewModel.init()
        }

    }

    private fun initObservers() {
        postsViewModel.loading.observe(this, ::showLoadingEvent)
        postsViewModel.postsLoaded.observe(this, ::setData)
    }

    private fun showLoadingEvent(loading: Boolean) {
       if (loading) showLoading() else hideLoading()
    }

    private fun showLoading() {
        binding.rvPosts.isVisible = false
        binding.progressBar.isVisible = true
    }

    private fun hideLoading() {
        binding.rvPosts.isVisible = true
        binding.progressBar.isVisible = false
    }

    private fun setData(posts: List<PostListItem>) {
        adapter.posts.clear()
        adapter.posts.addAll(posts)
    }

    private fun setDecorator() {
        binding.rvPosts.addItemDecoration(
            object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    if (parent.getChildLayoutPosition(view) == 0) {
                        outRect.top =
                            resources.getDimension(R.dimen.list_item_spacing).toInt()
                    }
                    outRect.bottom = resources.getDimension(R.dimen.list_item_spacing).toInt()
                }
            }
        )
    }

    private fun onPostClick(postId: Int) {
        val intent = Intent(this@PostsListActivity, FullPostActivity::class.java)
        intent.putExtra(POST_ID_ARG, postId)
        startActivity(intent)
    }

}