package com.example.basil.fragments

import RecipesFragmentParallaxPageTransformer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.basil.R
import com.example.basil.views.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_recipe.view.*

class RecipeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)

        view.recipe_view_pager.orientation = ViewPager2.ORIENTATION_VERTICAL
        view.recipe_view_pager.adapter = ViewPagerAdapter(this)
        view.recipe_view_pager.setPageTransformer(RecipesFragmentParallaxPageTransformer())
        view.recipe_view_pager.currentItem = 1

        return view
    }

}