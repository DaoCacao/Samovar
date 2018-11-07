package core.legion.samovar.screens.addRecipe

import android.content.Intent
import android.graphics.Bitmap
import core.legion.samovar.entry.IngredientItem
import io.reactivex.Single

interface AddRecipeFacade {

    interface View {
        fun showImage(image: Bitmap)
        fun showIngredients(ingredients: ArrayList<IngredientItem>)

        fun closeView()

        fun showChooseImageDialog()

        fun notifyIngredientAdded(pos: Int)
        fun notifyIngredientRemoved(pos: Int)
    }

    interface Presenter {
        fun onViewInit()

        fun onNameChanged(name: String)
        fun onDescriptionChanged(description: String)

        fun onImageClick()
        fun onAddClick()

        fun onImageFromGallery(data: Intent)
    }

    interface Interactor {
        fun getIngredients(): Single<ArrayList<IngredientItem>>
    }

    interface OnIngredientChangeListener {
        fun onIngredientChange(pos: Int, ingredient: String)
    }
}