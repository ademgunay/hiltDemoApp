package com.example.hiltdemo.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltdemo.data.AlbumEntity
import com.example.hiltdemo.usecase.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {

    val albumList = MutableLiveData<List<AlbumEntity>>()
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
}