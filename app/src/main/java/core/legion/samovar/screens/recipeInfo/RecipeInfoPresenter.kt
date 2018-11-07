package core.legion.samovar.screens.recipeInfo

import android.content.Intent
import core.legion.samovar.data.firebaseManager.DBManager
import core.legion.samovar.entry.RecipeItem
import core.legion.samovar.utils.Helper

class RecipeInfoPresenter(val view: RecipeInfoFacade.View, val firebase: DBManager) : RecipeInfoFacade.Presenter {

    private var recipeId = ""

    override fun handleIntent(intent: Intent) {
        recipeId = intent.getStringExtra(Helper.IntentExtra.RECIPE_ID)!!
    }

    override fun onResume() {
        firebase.getRecipe(recipeId).subscribe(this::showRecipe)
    }

    override fun onApproveClick() {
        firebase.approveRecipe(recipeId).subscribe(view::hideModerationButtons)
    }

    override fun onDeclineClick() {
        firebase.removeRecipe(recipeId).subscribe(view::closeView)
    }

    private fun showRecipe(item: RecipeItem) {
        view.showName(item.name)
        view.showDescription(item.description)
    }
}