package com.edurda77.testvicuesoft.data.mappers

import com.edurda77.testvicuesoft.data.remote.VideoDTO
import com.edurda77.testvicuesoft.domain.video.VideoData

fun VideoDTO.toVideoData(): List<VideoData> {
    return this.dataVideo.map {
        VideoData(
            videoUrl = it.fileUrl,
            posterUrl = it.posterUrl
        )
    }
}