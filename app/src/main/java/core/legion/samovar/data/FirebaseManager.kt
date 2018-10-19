package core.legion.samovar.data

import android.content.Context
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import core.legion.samovar.screens.recipeList.RecipeListItem
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseManager @Inject constructor(context: Context) : DBManager {

    private val collectionRecipes = "recipes"

    @Inject lateinit var fbStore: FirebaseFirestore

    override fun getRecipes(): Single<ArrayList<RecipeListItem>> {
        return Single.create {
            Log.e("###", "getRecipes")
            val ref = fbStore.collection(collectionRecipes)
            Log.e("###", ref.toString())
            val task = ref.get()
            Log.e("###", task.toString())

            task.addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    val recipeListItems = ArrayList<RecipeListItem>()
                    task.result?.forEach { recipeListItems += buildRecipeListItem(it) }

                    it.onSuccess(recipeListItems)

                } else Log.e("###", "something went wrong: ${task.exception}")
            }
        }
    }

    private fun buildRecipeListItem(snapshot: QueryDocumentSnapshot): RecipeListItem {
        return RecipeListItem(
                snapshot.id,
                snapshot.data["name"].toString()
        )
    }

}

