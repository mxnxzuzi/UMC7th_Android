package ddwu.com.mobile.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ddwu.com.mobile.myapplication.databinding.ActivitySongBinding

class SongActivity :AppCompatActivity() {
    val binding by lazy {
        ActivitySongBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val songTitle = intent.getStringExtra("songTitle")
        val singer = intent.getStringExtra("artistName")

        binding.songtitle.text = songTitle
        binding.singer.text = singer

        binding.backButton.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("albumTitle", getString(R.string.song_title))
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
        var isBlue = false //

        binding.shuffle.setOnClickListener {
            if (isBlue) {
                binding.shuffle.setColorFilter(Color.BLACK)
            } else {
                binding.shuffle.setColorFilter(Color.parseColor("#3F51B5"))
            }
            isBlue = !isBlue
        }

        binding.loop.setOnClickListener {
            if (isBlue) {
                binding.loop.setColorFilter(Color.BLACK)
            } else {
                binding.loop.setColorFilter(Color.parseColor("#3F51B5"))
            }
            isBlue = !isBlue
        }
        var isPlaying = false

        binding.playPauseButton.setOnClickListener {
            if (isPlaying) {
                binding.playPauseButton.setImageResource(R.drawable.baseline_play_arrow)
            } else {
                binding.playPauseButton.setImageResource(R.drawable.baseline_pause_24)
            }
            isPlaying = !isPlaying
        }
    }
}