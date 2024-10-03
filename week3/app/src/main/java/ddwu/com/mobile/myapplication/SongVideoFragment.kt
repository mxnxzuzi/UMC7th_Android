package ddwu.com.mobile.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ddwu.com.mobile.myapplication.databinding.FragmentSongDetailBinding
import ddwu.com.mobile.myapplication.databinding.FragmentSongVideoBinding

class SongVideoFragment : Fragment() {

    private lateinit var binding: FragmentSongVideoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}