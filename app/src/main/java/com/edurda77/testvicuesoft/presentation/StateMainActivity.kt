package com.edurda77.testvicuesoft.presentation

import com.edurda77.testvicuesoft.domain.video.VideoData

sealed interface StateMainActivity {
    object Loading : StateMainActivity
    class Failure(val error:String) : StateMainActivity
    class Success(val data: List<VideoData>) : StateMainActivity
}