package core.legion.samovar.screens.recipeList

import android.net.Uri
import core.legion.samovar.data.firebaseManager.DBManager
import core.legion.samovar.entry.RecipeListItem
import io.reactivex.Single
import javax.inject.Inject

class RecipeListInteractor @Inject constructor() : RecipeListFacade.Interactor {

    @Inject lateinit var firebase: DBManager

    private lateinit var recipeList: ArrayList<RecipeListItem>

    override fun getRecipeList(): Single<ArrayList<RecipeListItem>> {
        return firebase.getRecipeList().map { recipeList = it; it }
    }

    override fun getRecipeImage(id: String): Single<Pair<String, Uri>> {
        return firebase.getImageUrl(id).map { Pair(id, it) }
    }
}