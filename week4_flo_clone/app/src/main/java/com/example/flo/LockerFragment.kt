package com.example.flo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flo.databinding.FragmentLockerBinding
import com.google.android.material.tabs.TabLayoutMediator

class LockerFragment : Fragment() {
    lateinit var binding: FragmentLockerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLockerBinding.inflate(inflater, container, false)

        val savedSongs = mutableListOf(
            Album("Butter", "BTS", R.drawable.img_album_exp),
            Album("Lilac", "IU", R.drawable.img_album_exp2),
            Album("Next Level", "AESPA", R.drawable.img_album_exp3),
            Album("Boy with Luv", "BTS", R.drawable.img_album_exp4),
            Album("BBoom BBoom", "모모랜드", R.drawable.img_album_exp5),
            Album("Weekend", "태연", R.drawable.img_album_exp6),
            Album("Butter", "BTS", R.drawable.img_album_exp),
            Album("Lilac", "IU", R.drawable.img_album_exp2),
            Album("Next Level", "AESPA", R.drawable.img_album_exp3),
            Album("Boy with Luv", "BTS", R.drawable.img_album_exp4),
            Album("BBoom BBoom", "모모랜드", R.drawable.img_album_exp5),
            Album("Weekend", "태연", R.drawable.img_album_exp6),
            Album("Butter", "BTS", R.drawable.img_album_exp),
            Album("Lilac", "IU", R.drawable.img_album_exp2),
            Album("Next Level", "AESPA", R.drawable.img_album_exp3),
            Album("Boy with Luv", "BTS", R.drawable.img_album_exp4),
            Album("BBoom BBoom", "모모랜드", R.drawable.img_album_exp5),
            Album("Weekend", "태연", R.drawable.img_album_exp6)
        )

        // RecyclerView 설정
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = LockerAdapter(savedSongs)
        }

        return binding.root
    }
}

