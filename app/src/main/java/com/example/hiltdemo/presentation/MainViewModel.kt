package com.example.hiltdemo.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltdemo.data.AlbumEntity
import com.example.hiltdemo.data.PostEntity
import com.example.hiltdemo.usecase.GetAlbumsUseCase
import com.example.hiltdemo.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase,
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    val albumList = MutableLiveData<List<AlbumEntity>>()
    val postList = MutableLiveData<List<PostEntity>>()
    val errorMsg = MutableLiveData<String>()

    fun fetchAlbums() {
        viewModelScope.launch {
            try {
                albumList.value = getAlbumsUseCase.invoke()
            } catch (e: Exception) {
                errorMsg.value = e.message
            }
        }
    }

    //TODO fetch posts and replace recyclerview's albumAdapter by postAdapter
    fun fetchPosts() {
        viewModelScope.launch {
            try {
                postList.value = getPostsUseCase.invoke()
            } catch (e: Exception) {
                errorMsg.value = e.message
            }
        }
    }
}