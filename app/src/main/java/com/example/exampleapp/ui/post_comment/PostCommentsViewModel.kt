package com.example.exampleapp.ui.post_comment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exampleapp.domain.usecases.GetPostsCommentsUseCase
import com.example.exampleapp.ui.dto.PostCommentItem
import com.example.exampleapp.ui.mapper.PostCommentMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostCommentsViewModel(
    private val getPostsCommentsUseCase: GetPostsCommentsUseCase,
    private val postCommentMapper: PostCommentMapper
) : ViewModel() {
    private val _commentsLoaded = MutableLiveData<List<PostCommentItem>>()
    val commentsLoaded: LiveData<List<PostCommentItem>> get() = _commentsLoaded

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    suspend fun init() {
        _loading.value = true
        withContext(Dispatchers.IO) {
            val postComments = getPostsCommentsUseCase.getPostsComments()
            withContext(Dispatchers.Main) {
                _commentsLoaded.value = postComments.map {
                    postCommentMapper.postCommentToPostCommentItem(it)
                }
            }
        }
    }
}