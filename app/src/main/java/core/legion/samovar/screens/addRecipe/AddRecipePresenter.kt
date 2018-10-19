package core.legion.samovar.screens.addRecipe

import core.legion.samovar.base.BasePresenter
import core.legion.samovar.data.DBManager
import javax.inject.Inject

class AddRecipePresenter @Inject constructor() : BasePresenter<AddRecipeFacade.View>(), AddRecipeFacade.Presenter {

    @Inject lateinit var firebase: DBManager

    private var name = ""
    private var description = ""

    override fun onNameChanged(name: String) {
        this.name = name
    }

    override fun onDescriptionChanged(description: String) {
        this.description = description
    }

    override fun onAddClick() {
        firebase.addRecipe(name, description).subscribe { view.closeView() }
    }
}
