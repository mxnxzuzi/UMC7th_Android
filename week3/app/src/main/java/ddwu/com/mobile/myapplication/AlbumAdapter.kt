package ddwu.com.mobile.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter(
    private val albumList: List<Album>,
    private val onItemClick: (Album) -> Unit
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val albumImage: ImageView = view.findViewById(R.id.albumImage)
        val albumTitle: TextView = view.findViewById(R.id.albumTitle)
        val artistName: TextView = view.findViewById(R.id.artistName)

        init {
            view.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(albumList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albumList[position]
        holder.albumTitle.text = album.title
        holder.artistName.text = album.artist
        holder.albumImage.setImageResource(album.imageRes)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}
