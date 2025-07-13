package com.example.shoplyecommerceapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplyecommerceapp.R


class BannerAdapter(private val images: List<Int>):RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    inner class BannerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //lấy ra imageview từ itemview
        val bannerImage: ImageView = itemView.findViewById(R.id.banner_imgv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner_item,parent,false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bannerImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int = images.size
}