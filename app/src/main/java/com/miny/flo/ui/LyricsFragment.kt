package com.miny.flo.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miny.flo.viewModel.LyricsViewModel
import com.miny.flo.R

class LyricsFragment : Fragment() {

    companion object {
        fun newInstance() = LyricsFragment()
    }

    private lateinit var viewModel: LyricsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lyrics, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LyricsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}