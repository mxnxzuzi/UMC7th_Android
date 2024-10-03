package ddwu.com.mobile.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(private val songs: List<Album>) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    inner class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val songTitle: TextView = view.findViewById(R.id.songTitle) // item_song.xml의 ID에 맞춰 수정
        val artistName: TextView = view.findViewById(R.id.artistName) // ID 일치
        val playButton: ImageView = view.findViewById(R.id.playButton) // ID 일치
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.songTitle.text = song.title
        holder.artistName.text = song.artist
        holder.playButton.setImageResource(song.imageRes) // 재생 버튼 이미지 설정
    }

    override fun getItemCount(): Int {
        return songs.size
    }
}
