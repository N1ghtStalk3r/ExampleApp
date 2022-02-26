package com.example.exampleapp.ui.activity_post_full

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exampleapp.domain.usecases.GetPostsCommentsUseCase
import com.example.exampleapp.domain.usecases.GetPostsUseCase
import com.example.exampleapp.ui.dto.PostCommentItem
import com.example.exampleapp.ui.mapper.PostCommentMapper
import com.example.exampleapp.ui.mapper.PostMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FullPostViewModel(
    // Комментарии
    private val getPostsCommentsUseCase: GetPostsCommentsUseCase,
    private val postCommentMapper: PostCommentMapper
): ViewModel() {
    private val _postCommentLoaded =
        MutableLiveData<List<PostCommentItem>>()
    val postCommentLoaded: LiveData<List<PostCommentItem>> get() =
        _postCommentLoaded

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    suspend fun init() {
        _loading.value = true
        withContext(Dispatchers.Main) {
            val postComments = getPostsCommentsUseCase.getPostsComments()
            withContext(Dispatchers.Main) {
                _postCommentLoaded.value =
                    postComments.map {
                        postCommentMapper.postCommentToPostCommentItem(it)
                    }
            }
        }
        _loading.value = false
    }
}