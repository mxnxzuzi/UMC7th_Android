package ddwu.com.mobile.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import ddwu.com.mobile.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        replaceFragment(FirstFragment())

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_home -> {
                    replaceFragment(FirstFragment())
                    true
                }
                R.id.page_bag -> {
                    replaceFragment(SecondFragment())
                    true
                }
                R.id.page_fav -> {
                    replaceFragment(ThirdFragment())
                    true
                }
                R.id.page_receipt -> {
                    replaceFragment(FourthFragment())
                    true
                }
                R.id.page_myPage -> {
                    replaceFragment(FifthFragment())
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

        transaction.replace(R.id.frame_fragment, fragment)
        transaction.commit()
    }

}