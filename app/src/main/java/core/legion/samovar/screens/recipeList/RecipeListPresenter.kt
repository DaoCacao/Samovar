package core.legion.samovar.screens.recipeList

import android.net.Uri
import io.reactivex.Single

class RecipeListPresenter(val view: RecipeListFacade.View, val interactor: RecipeListFacade.Interactor) : RecipeListFacade.Presenter, RecipeListFacade.RecipeListListener {

    override fun onViewInit() {
        view.showLoading()
        interactor.getRecipeList().subscribe { list -> if (list.isEmpty()) view.showListEmpty() else view.showRecipes(list) }
    }

    override fun onItemClick(id: String) = view.navigateToRecipeInfo(id)

    override fun getImageUrl(id: String): Single<Pair<String, Uri>> {
        return interactor.getRecipeImage(id)
    }
}