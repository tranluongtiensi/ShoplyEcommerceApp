package com.example.shoplyecommerceapp.adapters

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplyecommerceapp.R
import com.example.shoplyecommerceapp.data.Footwear

class FootwearAdapter(private  val footwear: List<Footwear>):
    RecyclerView.Adapter<FootwearAdapter.FootwearViewHolder>(){

    inner class FootwearViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val productName : TextView = itemView.findViewById(R.id.product_name)
        val productImage : ImageView = itemView.findViewById(R.id.footwear_item_imgv)
        val productPrice : TextView = itemView.findViewById(R.id.product_price_dealed)
        val productRatelevel : TextView = itemView.findViewById(R.id.rating_level)
        val productRateQuantity : TextView = itemView.findViewById(R.id.rating_quantity)
        val productFavorite : ImageButton = itemView.findViewById(R.id.favorite_check_btn)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FootwearViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hot_footwear_item, parent, false )
        return FootwearViewHolder(view)
    }

    override fun onBindViewHolder(holder: FootwearViewHolder, position: Int) {
        val footwear = footwear[position]
        holder.productName.text=footwear.name
        holder.productImage.setImageResource(footwear.image)
        holder.productPrice.text = footwear.price
        holder.productRateQuantity.text = footwear.ratequantity
        holder.productRatelevel.text = footwear.ratelevel
        val favoriteIcon = if (footwear.isFavorite){
            holder.productFavorite.setColorFilter(
                ContextCompat.getColor(holder.itemView.context, R.color.favoritecolorischeck),
                PorterDuff.Mode.SRC_IN
            )
            R.drawable.favorite_fill_24px

        } else {
            holder.productFavorite.setColorFilter(
                ContextCompat.getColor(holder.itemView.context, R.color.favoritecolornocheck),
                PorterDuff.Mode.SRC_IN
            )
            R.drawable.favorite_24px
        }
        holder.productFavorite.setImageResource(favoriteIcon)

        holder.productFavorite.setOnClickListener{
            footwear.isFavorite  =  !footwear.isFavorite
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = footwear.size
}