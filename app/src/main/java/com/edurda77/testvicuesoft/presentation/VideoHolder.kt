package com.edurda77.testvicuesoft.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edurda77.testvicuesoft.databinding.ItemPosterRvBinding
import com.edurda77.testvicuesoft.domain.video.VideoData

class VideoHolder(private val binding: ItemPosterRvBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: VideoData) {
        Glide.with(this.itemView.context)
            .load(item.posterUrl)
            .into(binding.posterIv)
    }
}