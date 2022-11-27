package com.edurda77.testvicuesoft.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.testvicuesoft.domain.repository.VideoRepository
import com.edurda77.testvicuesoft.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: VideoRepository) : ViewModel() {

    private val _videoData =
        MutableLiveData<StateMainActivity>(StateMainActivity.Loading)
    val videoData = _videoData

    init {
        getVideo()
    }
    private fun getVideo() {
        viewModelScope.launch {
            when (val result = repository.getVideoData()) {
                is Resource.Success -> {
                    _videoData.value = StateMainActivity.Success(result.data?: emptyList())
                }
                is Resource.Error -> {
                    _videoData.value = StateMainActivity.Failure(result.message.toString())
                }
            }
        }
    }
}