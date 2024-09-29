package ddwu.com.mobile.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ddwu.com.mobile.myapplication.databinding.FragmentFirstBinding
import ddwu.com.mobile.myapplication.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {
    val binding by lazy {
        FragmentFourthBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}