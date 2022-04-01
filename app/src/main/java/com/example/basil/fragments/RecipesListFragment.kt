package com.example.basil.fragments

import RecipesParallaxPageTransformer
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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

    val TAG = "RecipesListFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipes_list, container, false)

        val windowSize = WindowSizeManager.computeWindowSize(resources)

        val recipes: ArrayList<Recipe> =
            getRecipesFromFilePath(this.requireActivity())

        val screenOrientation = resources.configuration.orientation
        if (windowSize == WindowSize.COMPACT) {
            if (screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
                view.recipes_view_pager.apply {
                    adapter = RecipesViewPagerAdapter(recipes)
                    orientation = ViewPager2.ORIENTATION_HORIZONTAL
                    setPageTransformer(RecipesParallaxPageTransformer())
                    (getChildAt(0) as RecyclerView)
                        .overScrollMode = RecyclerView.OVER_SCROLL_NEVER
                }
            } else {
                view.recipes_recycler_view.layoutManager =
                    LinearLayoutManager(
                        activity, LinearLayoutManager.HORIZONTAL, false
                    )
                view.recipes_recycler_view.adapter = RecipesViewPagerAdapter(recipes)
            }
        } else {
            var spanCount = if (screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
                3
            } else {
                2
            }
            view.recipes_recycler_view.setHasFixedSize(true)
            val staggeredLayoutManager =
                StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL)

            view.recipes_recycler_view.layoutManager = staggeredLayoutManager
            val adapter = RecipesRecyclerViewAdapter(recipes)
            view.recipes_recycler_view.adapter = adapter
        }

        return view
    }

}

