package com.example.basil.views.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basil.R

class RecipesRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var recipeImageView: ImageView = itemView.findViewById(R.id.recipe_image_view)
    var recipeTitle: TextView = itemView.findViewById(R.id.recipe_title)

}