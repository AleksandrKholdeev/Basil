package com.example.basil.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basil.R
import com.example.basil.model.Ingredient

class IngredientsRecyclerViewAdapter(private val ingredientList: List<Ingredient>) :
    RecyclerView.Adapter<IngredientsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.ingredient_item, parent, false
        )
        return IngredientsViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        if (position < ingredientList.size) {
            val ingredient = ingredientList[position]
            holder.ingredientName.text = ingredient.ingredientName
            holder.ingredientAmount.text = ingredient.ingredientAmount + ingredient.amountType
        }
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

}