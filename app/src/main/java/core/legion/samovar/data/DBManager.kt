package core.legion.samovar.data

import core.legion.samovar.screens.recipeList.RecipeListItem
import io.reactivex.Single

interface DBManager {
    fun getRecipes(): Single<ArrayList<RecipeListItem>>
}