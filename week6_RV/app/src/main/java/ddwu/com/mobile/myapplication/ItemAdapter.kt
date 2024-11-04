package ddwu.com.mobile.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class RestaurantItem(
    val name: String,       // 음식점 이름
    val description: String, // 음식 설명
    val deliveryTime: String // 배달 시간
)

class ItemAdapter(private val items: List<RestaurantItem>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val restaurantNameTextView: TextView = itemView.findViewById(R.id.restaurant_name_text_view)
        val restaurantDescriptionTextView: TextView = itemView.findViewById(R.id.restaurant_description_text_view)
        val deliveryTimeTextView: TextView = itemView.findViewById(R.id.delivery_time_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.restaurantNameTextView.text = currentItem.name
        holder.restaurantDescriptionTextView.text = currentItem.description
        holder.deliveryTimeTextView.text = currentItem.deliveryTime
    }

    override fun getItemCount(): Int = items.size
}
