package core.legion.samovar.screens.addRecipe

import android.content.Intent
import android.graphics.Bitmap
import core.legion.samovar.base.BaseFacade
import core.legion.samovar.entry.IngredientItem
import io.reactivex.Completable
import io.reactivex.Single

interface AddRecipeFacade {

    interface View : BaseFacade.View {
        fun showImage(image: Bitmap)
        fun showIngredients(ingredients: ArrayList<IngredientItem>)

        fun showChooseImageDialog()

        fun notifyIngredientAdded(pos: Int)
        fun notifyIngredientRemoved(pos: Int)
    }

    interface Presenter : BaseFacade.Presenter {
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