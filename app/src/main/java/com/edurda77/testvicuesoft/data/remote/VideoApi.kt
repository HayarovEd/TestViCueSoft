package com.edurda77.testvicuesoft.data.remote

import retrofit2.http.GET

interface VideoApi {

    @GET("api/backgrounds/?group=video&category_id=1")
    suspend fun getVideoData(
    ): List<VideoDTOItem>
}