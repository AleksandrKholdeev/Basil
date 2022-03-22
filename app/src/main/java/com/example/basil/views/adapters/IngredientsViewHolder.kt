package com.example.basil.views.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basil.R

class IngredientsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var addCircle: ImageView = itemView.findViewById(R.id.addCircleImageView__ingredient_item)
    var ingredientName: TextView =
        itemView.findViewById(R.id.ingredientNameTextView__ingredient_item)
    var ingredientAmount: TextView =
        itemView.findViewById(R.id.ingredientAmountTextView__ingredient_item)

}