package core.legion.samovar.data

import core.legion.samovar.entry.RecipeItem
import core.legion.samovar.entry.RecipeListItem
import io.reactivex.Completable
import io.reactivex.Single

interface DBManager {
    fun getRecipeList(): Single<ArrayList<RecipeListItem>>

    fun getRecipe(id: String): Single<RecipeItem>
    fun addRecipe(name: String, description: String, image: ByteArray): Completable
    fun removeRecipe(id: String): Completable

    fun approveRecipe(id: String): Completable

    fun downloadImage(id: String): Single<ByteArray>
}