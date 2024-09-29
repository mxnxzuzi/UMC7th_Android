package ddwu.com.mobile.myapplication

import android.os.Bundle
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


        loadFragment(FirstFragment(),false)
        updateButtonColors(binding.home)


        binding.home.setOnClickListener {
            loadFragment(FirstFragment(),true)
            updateButtonColors(binding.home)
        }


        binding.bag.setOnClickListener {
            loadFragment(SecondFragment(),true)
            updateButtonColors(binding.bag)
        }


        binding.fav.setOnClickListener {
            loadFragment(ThirdFragment(),true)
            updateButtonColors(binding.fav)
        }


        binding.receipt.setOnClickListener {
            loadFragment(FourthFragment(),true)
            updateButtonColors(binding.receipt)
        }


        binding.mypage.setOnClickListener {
            loadFragment(FifthFragment(),true)
            updateButtonColors(binding.mypage)
        }
    }


    private fun loadFragment(fragment: Fragment, addAnimation: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()

        if(addAnimation) {
            transaction.setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
        }
        transaction.replace(R.id.frame_fragment, fragment)
        transaction.commitAllowingStateLoss()
    }


    private fun updateButtonColors(selectedButton: ImageButton) {
        val defaultColor = ContextCompat.getColor(this, R.color.no_nav_color)

        val selectedColor = ContextCompat.getColor(this, R.color.selected_nav_color)

        val buttons = listOf(binding.home, binding.bag, binding.fav, binding.receipt, binding.mypage)
        buttons.forEach { button ->
            button.setColorFilter(defaultColor)
        }

        selectedButton.setColorFilter(selectedColor)
    }
}
