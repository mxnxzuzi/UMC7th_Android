package ddwu.com.mobile.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import ddwu.com.mobile.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val albumTitle = data?.getStringExtra("albumTitle")
            Toast.makeText(this, "앨범 이름: $albumTitle", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        setupMiniPlayer()

        if(savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.home
            replaceFragment(HomeFragment())
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.find -> {
                    replaceFragment(FindFragment())
                    true
                }
                R.id.search -> {
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.mypage -> {
                    replaceFragment(MypageFragment())
                    true
                }
                else -> false
            }

        }

    }
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.setCustomAnimations(
            android.R.anim.fade_in,
            android.R.anim.fade_out,
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )

        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
    private fun setupMiniPlayer() {
        binding.miniPlayer.setOnClickListener {
            val intent = Intent(this, SongActivity::class.java)
            intent.putExtra("songTitle", getString(R.string.song_title))
            intent.putExtra("artistName", getString(R.string.singer))

            resultLauncher.launch(intent)

        }
    }
}