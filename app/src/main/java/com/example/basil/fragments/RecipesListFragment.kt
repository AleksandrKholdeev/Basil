package com.example.basil.fragments

import RecipesParallaxPageTransformer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.basil.R
import com.example.basil.WindowSizeManager
import com.example.basil.getRecipesFromFilePath
import com.example.basil.model.Recipe
import com.example.basil.model.WindowSize
import com.example.basil.views.adapters.RecipesRecyclerViewAdapter
import com.example.basil.views.adapters.RecipesViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_recipes_list.view.*

class RecipesListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipes_list, container, false)

        val widthWindowSize = WindowSizeManager.computeWidthWindowSize(resources)

        val recipes: ArrayList<Recipe> =
            getRecipesFromFilePath(this.requireActivity())

        if (widthWindowSize == WindowSize.COMPACT) {
            view.recipes_view_pager.apply {
                adapter = RecipesViewPagerAdapter(recipes)
                orientation = ViewPager2.ORIENTATION_HORIZONTAL
                setPageTransformer(RecipesParallaxPageTransformer())
                (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            }
        } else {
            view.recipes_recycler_view.setHasFixedSize(true)
            val gridLayoutManager = GridLayoutManager(
                context, 6, RecyclerView.HORIZONTAL, false
            )
            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    when (position) {
                        0, 1, 2 -> return 2
                        3 -> return 6
                        4, 5, 6 -> return 2
                        7, 8 -> return 3
                        9, 10 -> return 3
                        11, 12, 13 -> return 2
                        14, 15 -> return 3
                        16, 17 -> return 3
                        else -> return 3
                    }
                }
            }

            view.recipes_recycler_view.layoutManager = gridLayoutManager
            view.recipes_recycler_view.adapter = RecipesRecyclerViewAdapter(recipes)
        }

        return view
    }

}

