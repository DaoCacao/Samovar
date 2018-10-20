package core.legion.samovar.screens.addRecipe

import android.content.Intent
import core.legion.samovar.base.BasePresenter
import core.legion.samovar.data.contentManager.ContentManager
import core.legion.samovar.data.firebaseManager.DBManager
import core.legion.samovar.utils.BitmapUtils
import javax.inject.Inject

class AddRecipePresenter @Inject constructor() : BasePresenter<AddRecipeFacade.View>(), AddRecipeFacade.Presenter {

    @Inject lateinit var firebase: DBManager
    @Inject lateinit var contentManager: ContentManager

    private var name = ""
    private var description = ""
    private var image: ByteArray = ByteArray(0)

    override fun onNameChanged(name: String) {
        this.name = name
    }

    override fun onDescriptionChanged(description: String) {
        this.description = description
    }

    override fun onImageClick() = view.showChooseImageDialog()

    override fun onAddClick() {
        firebase.addRecipe(name, description, image).subscribe { view.closeView() }
    }

    override fun onImageFromGallery(data: Intent) {
        contentManager.getImageFromUri(data.data).subscribe { image ->
            BitmapUtils.getBytes(image).subscribe { bytes -> this.image = bytes }
            view.showImage(image)
        }
    }
}
