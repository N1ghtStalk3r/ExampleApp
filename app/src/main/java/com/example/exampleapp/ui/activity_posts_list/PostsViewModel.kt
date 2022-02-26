package com.example.exampleapp.ui.activity_posts_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exampleapp.domain.usecases.GetPostsUseCase
import com.example.exampleapp.ui.dto.PostListItem
import com.example.exampleapp.ui.mapper.PostMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostsViewModel(
    private val getPostsUseCase: GetPostsUseCase,
    private val postMapper: PostMapper
) : ViewModel() {

    private val _postsLoaded = MutableLiveData<List<PostListItem>>()
    val postsLoaded: LiveData<List<PostListItem>> get() = _postsLoaded

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    suspend fun init(){
        _loading.value = true
        withContext(Dispatchers.IO){
            val posts = getPostsUseCase.getPosts()
            withContext(Dispatchers.Main){
                _postsLoaded.value = posts.map { postMapper.postToPostListItem(it) }
            }
        }
        _loading.value = false
    }

}