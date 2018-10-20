package core.legion.samovar.screens.addRecipe

import android.content.Intent
import android.graphics.Bitmap
import core.legion.samovar.base.BaseFacade

interface AddRecipeFacade {

    interface View : BaseFacade.View {
        fun showChooseImageDialog()
        fun showImage(image: Bitmap)
    }

    interface Presenter : BaseFacade.Presenter {

        fun onNameChanged(name: String)
        fun onDescriptionChanged(description: String)

        fun onImageClick()
        fun onAddClick()

        fun onImageFromGallery(data: Intent)
    }
}