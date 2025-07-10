package com.example.shoplyecommerceapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplyecommerceapp.data.CategoryDataModel
import com.example.shoplyecommerceapp.R

class CategoryAdapter(private val categories: List<CategoryDataModel>):
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon = view.findViewById<ImageView>(R.id.categories_icon)
        val name = view.findViewById<TextView>(R.id.categories_name)
        val card = view.findViewById<CardView>(R.id.categories_cardview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.name.text = category.name
        holder.icon.setImageResource(category.iconResId)
        holder.icon.setColorFilter(ContextCompat.getColor(holder.itemView.context, category.tintColor))
        holder.card.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, category.bgColor))
    }

    override fun getItemCount(): Int = categories.size
}