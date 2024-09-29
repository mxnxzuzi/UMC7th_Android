package ddwu.com.mobile.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ddwu.com.mobile.myapplication.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    val subBinding by lazy {
        ActivitySubBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(subBinding.root)
    }
}