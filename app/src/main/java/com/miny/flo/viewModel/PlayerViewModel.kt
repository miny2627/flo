package com.miny.flo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miny.flo.data.MusicData

class PlayerViewModel : ViewModel() {
    private val _album: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val album: LiveData<String>
        get() = _album

    private val _image: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val image: LiveData<String>
        get() = _image

    private val _lyrics: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val lyrics: LiveData<String>
        get() = _lyrics

    private val _singer: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val singer: LiveData<String>
        get() = _singer

    private val _title: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val title: LiveData<String>
        get() = _title

    fun setAlbum(album: String) {
        _album.value = album
    }
    fun setImage(image: String) {
        _image.value = image
    }
    fun setSinger(singer: String) {
        _singer.value = singer
    }
    fun setTitle(title: String) {
        _title.value = title
    }
}