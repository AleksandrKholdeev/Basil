package com.example.basil.fragments

import RecipeFragmentParallaxPageTransformer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.basil.R
import com.example.basil.WindowSizeManager
import com.example.basil.model.WindowSize
import com.example.basil.views.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_recipe.view.*

class RecipeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)

        val widthWindowSize = WindowSizeManager.computeWidthWindowSize(resources)

        if (widthWindowSize == WindowSize.COMPACT) {
            view.recipe_view_pager.orientation = ViewPager2.ORIENTATION_VERTICAL
            view.recipe_view_pager.adapter = ViewPagerAdapter(this)
            view.recipe_view_pager.setPageTransformer(RecipeFragmentParallaxPageTransformer())
            view.recipe_view_pager.currentItem = 1
        } else {
            childFragmentManager.beginTransaction()
                .add(R.id.shopping_list_frame_layout, ShoppingListFragment())
                .add(R.id.recipes_list_frame_layout, RecipesListFragment())
                .commit()
        }

        return view
    }

}