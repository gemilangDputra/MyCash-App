package com.gdpprod.mycash

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import android.graphics.Color
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {
    private lateinit var player: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.activity_main)

        val playerView = findViewById<PlayerView>(R.id.bannerVideo)

        player = ExoPlayer.Builder(this).build()

        playerView.player = player

        val uri = Uri.parse(
            "android.resource://$packageName/${R.raw.banner_test}"
        )

        val mediaItem = MediaItem.fromUri(uri)

        player.setMediaItem(mediaItem)
        player.repeatMode = ExoPlayer.REPEAT_MODE_ALL
        player.volume = 0f

        player.prepare()
        player.play()
    }

    override fun onStop() {
        super.onStop()
        player.release()
    }
}