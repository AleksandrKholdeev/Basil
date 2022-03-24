package com.example.basil.views.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basil.R
import com.example.basil.model.Recipe

class RecipesViewPagerAdapter(private val recipesList: List<Recipe>) :
    RecyclerView.Adapter<RecipesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recipe_item, parent, false
        )
        return RecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        if (position < recipesList.size) {
            val recipe = recipesList[position]

            val imageFile = holder.itemView.context.assets.open(recipe.recipeImagePath)
            val recipeImageDrawable = Drawable.createFromStream(imageFile, null)
            holder.recipeImageView.setImageDrawable(recipeImageDrawable)

            holder.recipeTitle.text = recipe.title
        }
    }

    override fun getItemCount() = recipesList.size

}