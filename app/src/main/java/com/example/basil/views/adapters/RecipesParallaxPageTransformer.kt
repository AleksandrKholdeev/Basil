import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.recipe_item.view.*

class RecipesParallaxPageTransformer : ViewPager2.PageTransformer {
    private lateinit var recipeImage: View
    private lateinit var recipeTitle: View
    override fun transformPage(page: View, position: Float) {
        recipeImage = page.recipe_image_view
        recipeTitle = page.recipe_title
        page.apply {
            if (position <= 1 && position >= -1) {
                recipeImage.translationX = -position * (width / 4f)
                recipeTitle.translationX = position * (width / 2f)
            }
        }
    }

}