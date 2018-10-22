package core.legion.samovar.screens.recipeList

import android.net.Uri
import core.legion.samovar.base.BasePresenter
import core.legion.samovar.data.firebaseManager.DBManager
import io.reactivex.Single
import javax.inject.Inject

class RecipeListPresenter @Inject constructor() : BasePresenter<RecipeListFacade.View>(), RecipeListFacade.Presenter, RecipeListFacade.RecipeListListener {

    @Inject lateinit var firebase: DBManager

    override fun onResume() {
        super<BasePresenter>.onResume()

        firebase.getRecipeList().subscribe { recipes -> view.setRecipes(recipes) }
    }

    override fun onItemClick(id: String) = view.navigateToRecipeInfo(id)

    override fun getImageUrl(id: String): Single<Pair<String,Uri>> {
        return firebase.getImageUrl(id).map { Pair(id, it) }
    }
}