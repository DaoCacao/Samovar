package core.legion.samovar.screens.recipeList

import android.graphics.Bitmap
import core.legion.samovar.base.BasePresenter
import core.legion.samovar.data.DBManager
import core.legion.samovar.utils.BitmapUtils
import io.reactivex.Single
import javax.inject.Inject

class RecipeListPresenter @Inject constructor() : BasePresenter<RecipeListFacade.View>(), RecipeListFacade.Presenter, RecipeListFacade.RecipeListListener {

    @Inject lateinit var firebase: DBManager

    override fun onResume() {
        super<BasePresenter>.onResume()

        firebase.getRecipeList().subscribe { recipes -> view.setRecipes(recipes) }
    }

    override fun onItemClick(id: String) = view.navigateToRecipeInfo(id)

    override fun loadImage(id: String): Single<Pair<String, Bitmap>> {
        return firebase.downloadImage(id)
                .flatMap { BitmapUtils.getBitmap(it) }
                .map { Pair(id, it) }
    }
}