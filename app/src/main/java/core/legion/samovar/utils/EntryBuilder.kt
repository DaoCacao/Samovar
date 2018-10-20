package core.legion.samovar.utils

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import core.legion.samovar.entry.RecipeItem
import core.legion.samovar.entry.RecipeListItem
import io.reactivex.Observable
import io.reactivex.Single

object EntryBuilder {

    private const val keyName = "name"
    private const val keyDescription = "description"

    fun buildRecipeList(snapshot: QuerySnapshot): Single<ArrayList<RecipeListItem>> {
        return Observable.fromIterable(snapshot)
                .flatMapSingle { buildRecipeListItem(it) }
                .toList { ArrayList<RecipeListItem>() }
    }

    fun buildRecipeListItem(snapshot: QueryDocumentSnapshot): Single<RecipeListItem> {
        return Single.just(RecipeListItem(snapshot.id, snapshot.getString(keyName)!!))
    }

    fun buildRecipeItem(name: String, description: String): Single<RecipeItem> {
        return Single.just(RecipeItem(name, description))
    }

    fun buildRecipeItem(snapshot: DocumentSnapshot): Single<RecipeItem> {
        return Single.just(RecipeItem(snapshot.getString(keyName)!!, snapshot.getString(keyDescription)!!))
    }
}