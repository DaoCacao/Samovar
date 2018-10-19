package core.legion.samovar.utils

import com.google.firebase.firestore.QueryDocumentSnapshot
import core.legion.samovar.entry.RecipeItem
import core.legion.samovar.entry.RecipeListItem

object EntryBuilder {

    private const val keyName = "name"
    private const val keyDescription = "description"

    fun buildRecipeListItem(snapshot: QueryDocumentSnapshot): RecipeListItem {
        return RecipeListItem(snapshot.id, snapshot.getString(keyName)!!)
    }

    fun buildRecipeItem(name: String, description: String): RecipeItem {
        return RecipeItem(name, description)
    }

    fun buildRecipeItem(snapshot: QueryDocumentSnapshot): RecipeItem {
        return RecipeItem(snapshot.getString(keyName)!!, snapshot.getString(keyDescription)!!)
    }
}