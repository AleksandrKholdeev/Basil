package com.example.basil

import android.content.res.Resources
import com.example.basil.model.WindowSize

class WindowSizeManager {

    companion object {

        fun computeHeightWindowSize(resources: Resources): WindowSize {
            val displayMetrics = resources.displayMetrics
            val heightDp = displayMetrics.heightPixels /
                    resources.displayMetrics.density

            val heightWindowSize = when {
                heightDp < 600f -> WindowSize.COMPACT
                else -> WindowSize.MEDIUM
            }

            return heightWindowSize
        }

        fun computeWidthWindowSize(resources: Resources): WindowSize {
            val displayMetrics = resources.displayMetrics
            val widthDp = displayMetrics.widthPixels /
                    resources.displayMetrics.density

            val widthWindowSize = when {
                widthDp < 600f -> WindowSize.COMPACT
                else -> WindowSize.MEDIUM
            }

            return widthWindowSize
        }

    }

}