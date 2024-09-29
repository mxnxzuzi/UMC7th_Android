package ddwu.com.mobile.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ddwu.com.mobile.myapplication.databinding.FragmentFifthBinding
import ddwu.com.mobile.myapplication.databinding.FragmentFirstBinding

class FifthFragment : Fragment() {
    val binding by lazy {
        FragmentFifthBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}