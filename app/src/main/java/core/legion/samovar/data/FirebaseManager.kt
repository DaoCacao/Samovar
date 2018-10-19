package core.legion.samovar.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import core.legion.samovar.entry.RecipeListItem
import core.legion.samovar.utils.EntryBuilder
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseManager @Inject constructor() : DBManager {

    private val collectionRecipesApproved = "recipes_approved"
    private val collectionRecipesReview = "recipes_review"

    @Inject lateinit var fbStore: FirebaseFirestore

    override fun getApprovedRecipeList(): Single<ArrayList<RecipeListItem>> = getRecipeList(collectionRecipesApproved)
    override fun getReviewedRecipeList(): Single<ArrayList<RecipeListItem>> = getRecipeList(collectionRecipesReview)

    private fun getRecipeList(collection: String): Single<ArrayList<RecipeListItem>> {
        return Single.create {
            fbStore.collection(collection)
                    .get()
                    .addOnSuccessListener { snapshot -> it.onSuccess(buildRecipeListFromSnapshot(snapshot)) }
        }
    }

    override fun addRecipeToReview(name: String, description: String): Completable {
        return Completable.create {
            fbStore.collection(collectionRecipesReview)
                    .add(EntryBuilder.buildRecipeItem(name, description))
                    .addOnSuccessListener { _ -> it.onComplete() }
        }
    }

    private fun buildRecipeListFromSnapshot(snapshot: QuerySnapshot): ArrayList<RecipeListItem> {
        return ArrayList<RecipeListItem>().apply {
            snapshot.forEach {
                add(EntryBuilder.buildRecipeListItem(it))
            }
        }
    }
}

