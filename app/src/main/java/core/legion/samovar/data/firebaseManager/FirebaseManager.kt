package core.legion.samovar.data.firebaseManager

import android.net.Uri
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageException
import core.legion.samovar.entry.RecipeItem
import core.legion.samovar.entry.RecipeListItem
import core.legion.samovar.utils.EntryBuilder
import io.reactivex.Completable
import io.reactivex.Single

class FirebaseManager(private val fbStore: FirebaseFirestore, private val fbStorage: FirebaseStorage) : DBManager {

    enum class FbException {
        OK,
        UNKNOWN
    }

    private val collectionRecipes = "recipes"

    override fun getRecipeList(): Single<ArrayList<RecipeListItem>> {
        return downloadRecipes()
                .flatMap { EntryBuilder.buildRecipeList(it) }
    }
    override fun getRecipe(id: String): Single<RecipeItem> {
        return downloadRecipe(id)
                .flatMap { EntryBuilder.buildRecipeItem(it) }
    }
    override fun getImageUrl(id: String): Single<Uri> {
        return Single.create {
            getImageRef(id).downloadUrl.addOnSuccessListener(it::onSuccess)
        }
    }

    override fun addRecipe(name: String, description: String, image: ByteArray): Completable {
        return EntryBuilder.buildRecipeItem(name, description)
                .flatMap { uploadRecipe(it) }
                .flatMapCompletable { uploadImage(it, image) }
    }
    override fun removeRecipe(id: String): Completable {
        return deleteRecipe(id)
                .flatMapCompletable { deleteImage(id) }
    }
    override fun approveRecipe(id: String): Completable {
        return Completable.create {
            getRecipeRef(id)
                    .update("is_approved", true)
                    .addOnSuccessListener { _ -> it.onComplete() }
        }
    }

    private fun downloadRecipes(): Single<QuerySnapshot>{
        return Single.create {
            getRecipeRef()
                    .get()
                    .addOnSuccessListener(it::onSuccess)
        }
    }

    private fun downloadRecipe(id: String): Single<DocumentSnapshot> {
        return Single.create {
            getRecipeRef(id)
                    .get()
                    .addOnSuccessListener(it::onSuccess)
        }
    }
    private fun uploadRecipe(recipeItem: RecipeItem): Single<String> {
        return Single.create {
            getRecipeRef()
                    .add(recipeItem)
                    .addOnSuccessListener { doc -> it.onSuccess(doc.id) }
        }
    }
    private fun deleteRecipe(id: String): Single<String> {
        return Single.create {
            getRecipeRef(id)
                    .delete()
                    .addOnSuccessListener { _ -> it.onSuccess(id) }
        }
    }

    private fun uploadImage(id: String, bytes: ByteArray): Completable {
        return Completable.create {
            if (bytes.isEmpty()) it.onComplete()
            else getImageRef(id)
                    .putBytes(bytes)
                    .addOnSuccessListener { _ -> it.onComplete() }
        }
    }
    private fun deleteImage(id: String): Completable {
        return Completable.create {
            getImageRef(id)
                    .delete()
                    .addOnSuccessListener { _ -> it.onComplete() }
                    .addOnFailureListener { exception -> if (checkException(exception) == FbException.OK) it.onComplete() }
        }
    }

    private fun checkException(exception: Exception): FbException {
        return when {
            exception is StorageException && exception.errorCode == StorageException.ERROR_OBJECT_NOT_FOUND -> FbException.OK
            else -> FbException.UNKNOWN
        }
    }

    private fun getRecipeRef() = fbStore.collection(collectionRecipes)
    private fun getRecipeRef(id: String) = getRecipeRef().document(id)
    private fun getImageRef(id: String) = fbStorage.reference.child(id)

}

