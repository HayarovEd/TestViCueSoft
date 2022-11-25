package com.edurda77.testvicuesoft.presentation

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.testvicuesoft.databinding.ActivityMainBinding
import com.edurda77.testvicuesoft.domain.video.VideoData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        viewModel.videoData.observe(this) {
            when (it) {
                is StateMainActivity.Loading -> {
                    binding.progressBar.isVisible=true
                    binding.frame.isVisible=false
                    binding.posterRv.isVisible=false
                }
                is StateMainActivity.Failure -> {
                    binding.progressBar.isVisible=false
                    binding.frame.isVisible=false
                    binding.posterRv.isVisible=false
                    Toast.makeText(this, it.error, Toast.LENGTH_LONG).show()
                }
                is StateMainActivity.Success -> {
                    binding.progressBar.isVisible=false
                    binding.frame.isVisible=true
                    binding.posterRv.isVisible=true
                    initRecyclerView(it.data)
                }
            }
        }
    }

    private fun initRecyclerView(data: List<VideoData>) {
        val recyclerView: RecyclerView = binding.posterRv
        val videoView = binding.playerVw
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager
            .HORIZONTAL, false)
        val stateClickListener: VideoAdapter.OnStateClickListener =
            object : VideoAdapter.OnStateClickListener {
                override fun onStateClick(item: VideoData, position: Int) {
                    videoView.setVideoURI(Uri.parse(item.videoUrl))
                    videoView.start()
                    videoView.setOnCompletionListener {
                        videoView.start()
                    }
                }
            }
        recyclerView.adapter = VideoAdapter(data,stateClickListener)
    }
}