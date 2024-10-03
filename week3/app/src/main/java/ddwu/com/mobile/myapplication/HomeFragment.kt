package ddwu.com.mobile.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import ddwu.com.mobile.myapplication.databinding.FragmentFindBinding
import ddwu.com.mobile.myapplication.databinding.FragmentHomeBinding
import ddwu.com.mobile.myapplication.databinding.FragmentSearchBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var albumAdapter: AlbumAdapter
    private val bannerImages = listOf(
        R.drawable.lilac,
        R.drawable.celebrity,
        R.drawable.twothree
    )
    private val albumList = listOf(
        Album("LILAC", "아이유 (IU)", R.drawable.lilac),
        Album("TWENTY-THREE", "아이유 (IU)", R.drawable.twothree),
        Album("CELEBRITY", "아이유 (IU)", R.drawable.celebrity)
    )
    private var currentPage = 0
    private val handler = Handler(Looper.getMainLooper())

    private val autoScrollRunnable = object : Runnable {
        override fun run() {
            if (currentPage == bannerImages.size) {
                currentPage = 0
            }
            binding.bannerViewPager.setCurrentItem(currentPage, true)
            currentPage++
            handler.postDelayed(this, 3000)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bannerAdapter = BannerAdapter(bannerImages)
        binding.bannerViewPager.adapter = bannerAdapter

        TabLayoutMediator(binding.dotsIndicator, binding.bannerViewPager) { _, _ -> }.attach()

        albumAdapter = AlbumAdapter(albumList) { album ->
            val albumFragment = AlbumFragment()
            val bundle = Bundle().apply {
                putString("albumTitle", album.title)
                putString("artistName", album.artist)
                putInt("albumImage", album.imageRes)
            }
            albumFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, albumFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = albumAdapter

        handler.postDelayed(autoScrollRunnable, 3000)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(autoScrollRunnable)
    }

}
