package com.miny.flo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentTransaction
import com.miny.flo.ui.PlayerFragment
import com.miny.flo.viewModel.PlayerViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: PlayerViewModel by viewModels()
    private val player: PlayerFragment by lazy {
        PlayerFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showMain()

    }
    private fun showMain() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, player)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
}