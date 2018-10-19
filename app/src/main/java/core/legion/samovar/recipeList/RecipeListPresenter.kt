package core.legion.samovar.recipeList

import core.legion.samovar.base.BasePresenter
import io.reactivex.Single
import javax.inject.Inject

class RecipeListPresenter @Inject constructor() : BasePresenter<RecipeListFacade.View, RecipeListFacade.Interactor>(), RecipeListFacade.Presenter {

    override fun onResume() {
        interactor.getAllRecipes().subscribe(view::setIds)
    }

    override fun onRecipeClick(id: Long) {
        view.showToast("Recipe $id")
    }

    override fun getRecipeListItem(id: Long): Single<RecipeListItem> = interactor.getRecipe(id)
}