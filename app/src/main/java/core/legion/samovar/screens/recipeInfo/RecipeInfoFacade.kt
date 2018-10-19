package core.legion.samovar.screens.recipeInfo

import android.content.Intent
import core.legion.samovar.base.BaseFacade

interface RecipeInfoFacade {

    interface View : BaseFacade.View {
        fun showName(name: String)
        fun showDescription(description: String)
    }

    interface Presenter : BaseFacade.Presenter {
        fun handleIntent(intent: Intent)
    }
}