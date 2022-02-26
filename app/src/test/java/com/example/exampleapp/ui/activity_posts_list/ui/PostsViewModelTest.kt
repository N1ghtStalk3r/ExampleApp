package com.example.exampleapp.ui.activity_posts_list.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.exampleapp.CoroutineExecutorRule
import com.example.exampleapp.domain.dto.Post
import com.example.exampleapp.domain.usecases.GetPostsUseCase
import com.example.exampleapp.ui.dto.PostListItem
import com.example.exampleapp.ui.mapper.PostMapper
import com.example.exampleapp.ui.activity_posts_list.PostsViewModel
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyAll
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class PostsViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineExecutorRule = CoroutineExecutorRule()

    private val useCase = mockk<GetPostsUseCase>()
    private val mapper = mockk<PostMapper>()
    private val viewModel = PostsViewModel(useCase, mapper)

    private val testPost = PostListItem(1, "content")

    private val posts = listOf(Post(1,1, "title", "content"))

    private val postItems = listOf(testPost)

    private val postLoadedObserver = mockk<Observer<List<PostListItem>>>()
    private val loadingObserver = mockk<Observer<Boolean>>()

    @Before
    fun setUp() {
        every { mapper.postToPostListItem(any()) } returns testPost
        every { postLoadedObserver.onChanged(any()) } just Runs
        every { loadingObserver.onChanged(any()) } just Runs
    }

    @Test
    fun testInit() = runBlocking {
        viewModel.postsLoaded.observeForever(postLoadedObserver)

        every { runBlocking {  useCase.getPosts() } } returns posts

        viewModel.init()

        verify { postLoadedObserver.onChanged(postItems) }

    }

    @Test
    fun testLoading() = runBlocking {
        viewModel.loading.observeForever(loadingObserver)

        every { runBlocking {  useCase.getPosts() } } returns posts

        viewModel.init()

        verifyAll {
            loadingObserver.onChanged(true)
            loadingObserver.onChanged(false)
        }

    }


}