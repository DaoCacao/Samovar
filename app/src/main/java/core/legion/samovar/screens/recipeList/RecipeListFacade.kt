package core.legion.samovar.screens.recipeList

import android.net.Uri
import core.legion.samovar.base.BaseFacade
import core.legion.samovar.entry.RecipeListItem
import io.reactivex.Single

interface RecipeListFacade {
    interface View : BaseFacade.View {
        fun setRecipes(recipes: ArrayList<RecipeListItem>)

        fun navigateToRecipeInfo(id: String)
    }

    interface Presenter : BaseFacade.Presenter

    interface RecipeListListener {
        fun onItemClick(id: String)

        fun getImageUrl(id: String): Single<Pair<String,Uri>>
    }
}