package com.example.basil.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basil.R
import com.example.basil.model.Ingredient
import com.example.basil.views.adapters.IngredientsRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_ingredients.view.*

class IngredientsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ingredients, container, false)

        view.ingredients_recycler_view.setHasFixedSize(true)
        view.ingredients_recycler_view.layoutManager = LinearLayoutManager(activity)
        view.ingredients_recycler_view.adapter =
            IngredientsRecyclerViewAdapter(getCustomIngredients())

        return view
    }

    private fun getCustomIngredients(): ArrayList<Ingredient> {
        val ingredients = ArrayList<Ingredient>()

        ingredients.add(Ingredient("Vine-ripened cherry truss tomatoes", "12", "pc"))
        ingredients.add(Ingredient("Caster sugar", "125", "g"))
        ingredients.add(Ingredient("Basil leaves", "12", "pc"))
        ingredients.add(Ingredient("Goat's cheese, at room temperature", "150", "g"))
        ingredients.add(Ingredient("Finely grated orange rind", "1/2", "tsp"))
        ingredients.add(Ingredient("Finely grated lemon rind", "1/2", "tsp"))
        ingredients.add(Ingredient("Vine-ripened cherry truss tomatoes", "12", "pc"))

        return ingredients
    }

}