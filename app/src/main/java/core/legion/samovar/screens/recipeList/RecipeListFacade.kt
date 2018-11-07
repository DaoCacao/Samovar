package core.legion.samovar.screens.recipeList

import android.net.Uri
import core.legion.samovar.entry.RecipeListItem
import io.reactivex.Single

interface RecipeListFacade {
    interface View {
        fun showLoading()
        fun showListEmpty()
        fun showRecipes(recipes: ArrayList<RecipeListItem>)

        fun navigateToRecipeInfo(id: String)
    }

    interface Presenter {
        fun onViewInit()
    }

    interface Interactor {
        fun getRecipeList(): Single<ArrayList<RecipeListItem>>
        fun getRecipeImage(id: String): Single<Pair<String, Uri>>
    }

    interface RecipeListListener {
        fun onItemClick(id: String)

        fun getImageUrl(id: String): Single<Pair<String, Uri>>
    }
}