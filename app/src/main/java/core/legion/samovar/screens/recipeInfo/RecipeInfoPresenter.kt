package core.legion.samovar.screens.recipeInfo

import android.content.Intent
import core.legion.samovar.base.BasePresenter
import core.legion.samovar.data.firebaseManager.DBManager
import core.legion.samovar.entry.RecipeItem
import core.legion.samovar.utils.Helper
import javax.inject.Inject

class RecipeInfoPresenter @Inject constructor() : BasePresenter<RecipeInfoFacade.View>(), RecipeInfoFacade.Presenter {

    @Inject lateinit var firebase: DBManager

    private var recipeId = ""

    override fun handleIntent(intent: Intent) {
        recipeId = intent.getStringExtra(Helper.IntentExtra.RECIPE_ID)!!
    }

    override fun onResume() {
        super<BasePresenter>.onResume()
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