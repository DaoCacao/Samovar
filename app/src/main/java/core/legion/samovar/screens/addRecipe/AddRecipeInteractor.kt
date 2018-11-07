package core.legion.samovar.screens.addRecipe

import core.legion.samovar.entry.IngredientItem
import io.reactivex.Single

class AddRecipeInteractor : AddRecipeFacade.Interactor {

    private var ingredients = arrayListOf(IngredientItem(), IngredientItem())

    override fun getIngredients(): Single<ArrayList<IngredientItem>> = Single.just(ingredients)

}
