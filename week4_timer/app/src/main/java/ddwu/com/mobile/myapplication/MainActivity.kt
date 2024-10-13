package ddwu.com.mobile.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import ddwu.com.mobile.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isRunning = false
    private var time = 0L
    private var timerJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            if (isRunning) {
                pauseTimer()
            } else {
                startTimer()
            }
        }

        binding.clearButton.setOnClickListener {
            clearTimer()
        }
    }
    private fun startTimer() {
        isRunning = true
        binding.startButton.text = "Pause"

        timerJob = lifecycleScope.launch {
            while (true) {
                delay(10)
                time++
                binding.timerTextView.text = formatTime(time)
            }
        }
    }

    private fun pauseTimer() {
        isRunning = false
        binding.startButton.text = "Start"
        timerJob?.cancel()
    }

    private fun clearTimer() {
        if (isRunning) {
            time = 0
            binding.timerTextView.text = formatTime(time)
        } else {
            pauseTimer()
            time = 0
            binding.timerTextView.text = formatTime(time)
        }
    }

    private fun formatTime(time: Long): String {
        val minutes = time / 6000
        val seconds = (time / 100) % 60
        val milliseconds = time % 100
        return String.format("%02d:%02d,%02d", minutes, seconds, milliseconds)
    }
}