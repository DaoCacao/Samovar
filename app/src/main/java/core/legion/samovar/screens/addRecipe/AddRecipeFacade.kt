package core.legion.samovar.screens.addRecipe

import core.legion.samovar.base.BaseFacade

interface AddRecipeFacade {

    interface View : BaseFacade.View

    interface Presenter : BaseFacade.Presenter {
        fun onNameChanged(name: String)
        fun onDescriptionChanged(description: String)

        fun onAddClick()
    }
}