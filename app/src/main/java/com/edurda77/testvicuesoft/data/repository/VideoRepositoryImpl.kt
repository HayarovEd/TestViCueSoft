package com.edurda77.testvicuesoft.data.repository

import com.edurda77.testvicuesoft.data.mappers.toVideoData
import com.edurda77.testvicuesoft.data.remote.VideoApi
import com.edurda77.testvicuesoft.domain.repository.VideoRepository
import com.edurda77.testvicuesoft.domain.utils.Resource
import com.edurda77.testvicuesoft.domain.video.VideoData
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(val api: VideoApi) : VideoRepository{
    override suspend fun getVideoData(): Resource<List<VideoData>> {
        return try {
            Resource.Success(
                data = api.getVideoData(
                ).toVideoData()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

}