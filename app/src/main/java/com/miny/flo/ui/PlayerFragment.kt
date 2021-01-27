package com.miny.flo.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.miny.flo.R
import com.miny.flo.api.MusicService
import com.miny.flo.data.MusicData
import com.miny.flo.databinding.FragmentPlayerBinding
import com.miny.flo.viewModel.PlayerViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayerFragment : Fragment() {
    private val viewModel: PlayerViewModel by viewModels()
    private lateinit var binding: FragmentPlayerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player, container, false)
        binding.music = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getMusic()
    }

    private fun getMusic() {
        val api = MusicService.getService().getMusic()
        api.enqueue(object: Callback<MusicData> {
            override fun onResponse(call: Call<MusicData>, response: Response<MusicData>) {
                // response failure
                if(!response.isSuccessful) return
                // success
                val body = response.body()
                body?.apply {
                    viewModel.setAlbum(album)
                    viewModel.setImage(image)
                    viewModel.setSinger(singer)
                    viewModel.setTitle(title)
                }
            }

            override fun onFailure(call: Call<MusicData>, t: Throwable) {
                Log.e("Error", "${t.message}")
            }
        })
    }
}