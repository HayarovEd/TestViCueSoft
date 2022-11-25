package com.edurda77.testvicuesoft.data.remote


import com.google.gson.annotations.SerializedName

data class VideoDTOItem(
    @SerializedName("color")
    val color: Any,
    @SerializedName("file_url")
    val fileUrl: String,
    @SerializedName("group")
    val group: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_favorite")
    val isFavorite: Boolean,
    @SerializedName("poster_url")
    val posterUrl: String,
    @SerializedName("small_poster_url")
    val smallPosterUrl: String,
    @SerializedName("small_thumbnail_url")
    val smallThumbnailUrl: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String
)