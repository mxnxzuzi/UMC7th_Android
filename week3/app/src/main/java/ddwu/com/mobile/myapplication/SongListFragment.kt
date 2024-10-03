package ddwu.com.mobile.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.com.mobile.myapplication.databinding.FragmentSongListBinding

class SongListFragment : Fragment() {

    private lateinit var binding: FragmentSongListBinding
    private lateinit var songAdapter: SongAdapter

    private val songList = listOf(
        Album("LILAC", "아이유 (IU)", R.drawable.lilac),
        Album("TWENTY-THREE", "아이유 (IU)", R.drawable.twothree),
        Album("CELEBRITY", "아이유 (IU)", R.drawable.celebrity)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView 설정
        songAdapter = SongAdapter(songList)
        binding.songRecyclerView.adapter = songAdapter
        binding.songRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}