package core.legion.samovar.screens.addRecipe

import android.content.Intent
import core.legion.samovar.data.contentManager.ContentManager
import core.legion.samovar.data.firebaseManager.DBManager
import core.legion.samovar.utils.BitmapUtils

class AddRecipePresenter(private val view: AddRecipeFacade.View, private var interactor: AddRecipeFacade.Interactor, private var firebase: DBManager, private var contentManager: ContentManager) : AddRecipeFacade.Presenter {

    private var image: ByteArray = ByteArray(0)
    private var name = ""
    private var description = ""

    override fun onViewInit() {
        interactor.getIngredients().subscribe(view::showIngredients)
        interactor.getEquipments().subscribe(view::showEquipments)
        interactor.getRecipePoints().subscribe(view::showRecipePoints)
    }

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
