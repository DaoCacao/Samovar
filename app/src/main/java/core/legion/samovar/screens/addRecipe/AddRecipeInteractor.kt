package core.legion.samovar.screens.addRecipe

import core.legion.samovar.entry.IngredientItem
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class AddRecipeInteractor @Inject constructor() : AddRecipeFacade.Interactor {

    private var ingredients = arrayListOf(IngredientItem(), IngredientItem())

    override fun getIngredients(): Single<ArrayList<IngredientItem>> = Single.just(ingredients)

}
