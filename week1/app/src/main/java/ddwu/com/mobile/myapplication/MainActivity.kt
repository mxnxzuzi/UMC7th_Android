package ddwu.com.mobile.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwu.com.mobile.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
/*        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        val clickListener = View.OnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
        binding.imageView2.setOnClickListener (clickListener)
        binding.imageView3.setOnClickListener (clickListener)
        binding.imageView4.setOnClickListener (clickListener)
        binding.imageView5.setOnClickListener (clickListener)
        binding.imageView6.setOnClickListener (clickListener)
    }
}