import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_shopping_list.view.*

class RecipeFragmentParallaxPageTransformer : ViewPager2.PageTransformer {
    private lateinit var shoppingListLinearLayout: View

    override fun transformPage(page: View, position: Float) {
        if (page.shopping_list_linear_layout != null) {
            shoppingListLinearLayout = page.shopping_list_linear_layout
            page.apply {
                if (position <= 1 && position >= -1) {
                    shoppingListLinearLayout.translationY = -position * (width / 1.5f)
                }
            }
        }
    }

}