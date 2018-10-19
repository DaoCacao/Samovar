package core.legion.samovar.utils

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import core.legion.samovar.entry.RecipeItem
import core.legion.samovar.entry.RecipeListItem

object EntryBuilder {

    private const val keyName = "name"
    private const val keyDescription = "description"

    fun buildRecipeList(snapshot: QuerySnapshot): ArrayList<RecipeListItem> {
        return ArrayList<RecipeListItem>().apply {
            snapshot.forEach {
                add(EntryBuilder.buildRecipeListItem(it))
            }
        }
    }

    fun buildRecipeListItem(snapshot: QueryDocumentSnapshot): RecipeListItem {
        return RecipeListItem(snapshot.id, snapshot.getString(keyName)!!)
    }

    fun buildRecipeItem(name: String, description: String): RecipeItem {
        return RecipeItem(name, description)
    }

    fun buildRecipeItem(snapshot: DocumentSnapshot): RecipeItem {
        return RecipeItem(snapshot.getString(keyName)!!, snapshot.getString(keyDescription)!!)
    }
}