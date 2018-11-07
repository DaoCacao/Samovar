package core.legion.samovar.screens.recipeInfo

import android.content.Intent

interface RecipeInfoFacade {

    interface View {

        fun showName(name: String)
        fun showDescription(description: String)

        fun closeView()

        fun hideModerationButtons()
    }

    interface Presenter {
        fun handleIntent(intent: Intent)

        fun onResume()

        fun onApproveClick()
        fun onDeclineClick()
    }
}