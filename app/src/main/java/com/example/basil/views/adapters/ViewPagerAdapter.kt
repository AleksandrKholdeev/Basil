package com.example.basil.views.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.basil.fragments.RecipesFragment
import com.example.basil.fragments.ShoppingListFragment

class ViewPagerAdapter(fragment: Fragment?) :
    FragmentStateAdapter(fragment!!) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return ShoppingListFragment()
        } else {
            return RecipesFragment()
        }
    }
}