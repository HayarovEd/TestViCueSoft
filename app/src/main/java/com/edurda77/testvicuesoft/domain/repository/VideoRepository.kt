package com.edurda77.testvicuesoft.domain.repository

import com.edurda77.testvicuesoft.domain.utils.Resource
import com.edurda77.testvicuesoft.domain.video.VideoData

interface VideoRepository {
    suspend fun getVideoData(): Resource<List<VideoData>>
}