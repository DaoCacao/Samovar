package core.legion.samovar.data

import core.legion.samovar.entry.RecipeListItem
import io.reactivex.Completable
import io.reactivex.Single

interface DBManager {
    fun getApprovedRecipeList(): Single<ArrayList<RecipeListItem>>
    fun getReviewedRecipeList(): Single<ArrayList<RecipeListItem>>

    fun addRecipeToReview(name: String, description: String): Completable
}