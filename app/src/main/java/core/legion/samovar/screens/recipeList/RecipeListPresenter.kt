package core.legion.samovar.screens.recipeList

import android.net.Uri
import core.legion.samovar.base.BasePresenter
import io.reactivex.Single
import javax.inject.Inject

class RecipeListPresenter @Inject constructor() : BasePresenter<RecipeListFacade.View>(), RecipeListFacade.Presenter, RecipeListFacade.RecipeListListener {

    @Inject lateinit var interactor: RecipeListFacade.Interactor

    override fun onViewInit() {
        interactor.getRecipeList().subscribe(view::setRecipes)
    }

    override fun onItemClick(id: String) = view.navigateToRecipeInfo(id)

    override fun getImageUrl(id: String): Single<Pair<String,Uri>> {
        return interactor.getRecipeImage(id)
    }
}