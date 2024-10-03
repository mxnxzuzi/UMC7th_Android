package ddwu.com.mobile.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ddwu.com.mobile.myapplication.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {

    private lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumTitle = arguments?.getString("albumTitle")
        val artistName = arguments?.getString("artistName")
        val albumImage = arguments?.getInt("albumImage")

        val albumPagerAdapter = AlbumPagerAdapter(childFragmentManager)
        binding.viewPager.adapter = albumPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.albumTitle.text = albumTitle
        binding.artistName.text = artistName
        albumImage?.let {
            binding.albumImage.setImageResource(it)
        }

        binding.backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}
class AlbumPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = listOf(
        SongListFragment(),
        SongDetailFragment(),
        SongVideoFragment()
    )

    private val titles = listOf(
        "수록곡", "상세정보", "영상"
    )

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}