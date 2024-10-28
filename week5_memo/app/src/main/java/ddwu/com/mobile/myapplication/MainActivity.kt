package ddwu.com.mobile.myapplication

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ddwu.com.mobile.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var savedMemo = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.nextButton.setOnClickListener(View.OnClickListener { v: View? ->
            val memoContent = binding.memoEditText.getText().toString()
            showMemoContent(memoContent)
        })
    }

    override fun onResume() {
        super.onResume()
        if (!savedMemo.isEmpty()) {
            binding.memoEditText!!.setText(savedMemo)
        }
    }

    override fun onPause() {
        super.onPause()
        savedMemo = binding.memoEditText!!.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setTitle("다시 작성하시겠습니까?")
            .setMessage("작성했던 내용을 지우고 새로 작성하시겠어요?")
            .setPositiveButton("예") { dialog: DialogInterface?, which: Int ->
                savedMemo = ""
                binding.memoEditText!!.setText("")
            }
            .setNegativeButton("아니오", null)
            .show()
    }

    private fun showMemoContent(memoContent: String) {
        setContentView(R.layout.activity_display_memo)
        val memoTextView = findViewById<TextView>(R.id.memoTextView)
        memoTextView.text = memoContent
    }
}
