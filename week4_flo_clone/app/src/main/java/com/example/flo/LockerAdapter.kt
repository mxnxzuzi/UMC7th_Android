package com.example.flo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flo.databinding.FragmentLockerSavedsongBinding

class LockerAdapter(private val items: MutableList<Album>) : RecyclerView.Adapter<LockerAdapter.LockerViewHolder>() {

    // ViewHolder 정의
    inner class LockerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val albumCoverImageView: ImageView = itemView.findViewById(R.id.item_song_img_iv)
        val albumTitleTextView: TextView = itemView.findViewById(R.id.item_song_title_tv)
        val singerTextView: TextView = itemView.findViewById(R.id.item_song_singer_tv)
        val playImageView: ImageView = itemView.findViewById(R.id.item_song_play_iv)
        val moreImageView: ImageView = itemView.findViewById(R.id.item_song_more_iv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LockerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return LockerViewHolder(view)
    }

    override fun onBindViewHolder(holder: LockerViewHolder, position: Int) {
        val currentItem = items[position]
        currentItem.coverImg?.let { holder.albumCoverImageView.setImageResource(it) } // 앨범 이미지 설정
        holder.albumTitleTextView.text = currentItem.title // 앨범 제목 설정
        holder.singerTextView.text = currentItem.singer // 가수 이름 설정

        holder.moreImageView.setOnClickListener {
            removeItem(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    private fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, items.size)
    }
}
