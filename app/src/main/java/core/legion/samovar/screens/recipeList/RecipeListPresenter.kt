package core.legion.samovar.screens.recipeList

import core.legion.samovar.base.BasePresenter
import core.legion.samovar.data.DBManager
import javax.inject.Inject

class RecipeListPresenter @Inject constructor() : BasePresenter<RecipeListFacade.View>(), RecipeListFacade.Presenter, RecipeListFacade.RecipeListListener {

    @Inject lateinit var dbManager: DBManager

    override fun onResume() {
        super<BasePresenter>.onResume()
        dbManager.getApprovedRecipeList().subscribe { recipes -> view.setRecipes(recipes) }
    }

    override fun onItemClick(id: String) {
        view.navigateToRecipeInfo(id)
    }
}