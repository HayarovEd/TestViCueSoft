package com.edurda77.testvicuesoft.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.testvicuesoft.databinding.ItemPosterRvBinding
import com.edurda77.testvicuesoft.domain.video.VideoData

class VideoAdapter(
    private val list: List<VideoData>,
    private val onClickListener: OnStateClickListener
) :
    RecyclerView.Adapter<VideoHolder>() {

    interface OnStateClickListener {
        fun onStateClick(item: VideoData, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        val inflater = LayoutInflater.from(parent.context)
        return VideoHolder(ItemPosterRvBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        val item: VideoData = list[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            onClickListener.onStateClick(item, position)
        }
    }

    override fun getItemCount(): Int = list.size
}