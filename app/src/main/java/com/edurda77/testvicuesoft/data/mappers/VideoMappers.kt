package com.edurda77.testvicuesoft.data.mappers

import com.edurda77.testvicuesoft.data.remote.VideoDTOItem
import com.edurda77.testvicuesoft.domain.video.VideoData

fun List<VideoDTOItem>.toVideoData(): List<VideoData> {
    return this.map {
        VideoData(
            videoUrl = it.fileUrl,
            posterUrl = it.posterUrl
        )
    }
}