package core.legion.samovar.data

import com.google.firebase.firestore.FirebaseFirestore
import core.legion.samovar.entry.RecipeItem
import core.legion.samovar.entry.RecipeListItem
import core.legion.samovar.utils.EntryBuilder
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseManager @Inject constructor() : DBManager {

    private val collectionRecipes = "recipes"

    @Inject lateinit var fbStore: FirebaseFirestore


    override fun getRecipeList(): Single<ArrayList<RecipeListItem>> {
        return Single.create {
            fbStore.collection(collectionRecipes)
                    .get()
                    .addOnSuccessListener { snapshot ->
                        it.onSuccess(EntryBuilder.buildRecipeList(snapshot))
                    }
        }
    }

    override fun getRecipe(id: String): Single<RecipeItem> {
        return Single.create {
            fbStore.collection(collectionRecipes)
                    .document(id)
                    .get()
                    .addOnSuccessListener { snapshot -> it.onSuccess(EntryBuilder.buildRecipeItem(snapshot)) }
        }
    }

    override fun addRecipe(name: String, description: String): Completable {
        return Completable.create {
            fbStore.collection(collectionRecipes)
                    .add(EntryBuilder.buildRecipeItem(name, description))
                    .addOnSuccessListener { _ -> it.onComplete() }
        }
    }

    override fun approveRecipe(id: String): Completable {
        return Completable.create {
            fbStore.collection(collectionRecipes)
                    .document(id)
                    .update("is_approved", true)
                    .addOnSuccessListener { _ -> it.onComplete() }
        }
    }

    override fun deleteRecipe(id: String): Completable {
        return Completable.create {
            fbStore.collection(collectionRecipes)
                    .document(id)
                    .delete()
                    .addOnSuccessListener { _ -> it.onComplete() }
        }
    }
}

