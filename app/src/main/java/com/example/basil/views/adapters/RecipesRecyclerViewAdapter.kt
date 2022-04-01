package com.example.basil.views.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basil.R
import com.example.basil.model.Recipe

class RecipesRecyclerViewAdapter(private val recipes: List<Recipe>?) :
    RecyclerView.Adapter<RecipesRecyclerViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if (position == 0 || position % 18 == 0)
            return 1
        if (position == 1 || position % 19 == 0) {
            return 2
        } else if (position % 16 == 0) {
            return 3
        } else if (position % 15 == 0) {
            return 3
        } else if (position % 14 == 0) {
            return 2
        } else if (position % 13 == 0) {
            return 2
        } else if (position % 12 == 0) {
            return 1
        } else if (position % 11 == 0) {
            return 3
        } else if (position % 10 == 0) {
            return 3
        } else if (position % 9 == 0) {
            return 2
        } else if (position % 8 == 0) {
            return 2
        } else if (position % 7 == 0) {
            return 2
        } else if (position % 6 == 0) {
            return 1
        } else if (position % 5 == 0) {
            return 3
        } else if (position % 4 == 0) {
            return 3
        } else if (position % 3 == 0) {
            return 2
        } else if (position % 2 == 0) {
            return 2
        } else if (position % 17 == 0) {
            return 2
        } else {
            return 2
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipesRecyclerViewHolder {
        var layoutId = R.layout.recyler_recipe_item_first
        if (viewType == 1) {
            layoutId = R.layout.recyler_recipe_item_first
        } else if (viewType == 2) {
            layoutId = R.layout.recyler_recipe_item_second
        } else if (viewType == 3) {
            layoutId = R.layout.recyler_recipe_item_third
        }

        val layoutView = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)
        return RecipesRecyclerViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: RecipesRecyclerViewHolder, position: Int) {
        if (recipes != null && position < recipes.size) {
            val recipe = recipes[position]

            val imageFile = holder.itemView.context.assets.open(recipe.recipeImagePath)
            val recipeImageDrawable = Drawable.createFromStream(imageFile, null)
            holder.recipeImageView.setImageDrawable(recipeImageDrawable)

            holder.recipeTitle.text = recipe.title
        }
    }

    override fun getItemCount(): Int {
        return recipes?.size ?: 0
    }

}

