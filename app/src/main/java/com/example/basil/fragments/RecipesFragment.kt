package com.example.basil.fragments

import RecipesParallaxPageTransformer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.basil.R
import com.example.basil.getRecipesFromFilePath
import com.example.basil.model.Recipe
import com.example.basil.views.adapters.RecipesViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_recipes.view.*

class RecipesFragment : Fragment() {

    val TAG = "RecipesFragmentLog"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)

        // Set up view pager of recipes
        val recipes: ArrayList<Recipe> =
            getRecipesFromFilePath(this.requireActivity())
        view.recipes_view_pager.apply {
            adapter = RecipesViewPagerAdapter(recipes)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            setPageTransformer(RecipesParallaxPageTransformer())
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        return view
    }

}

