package core.legion.samovar.screens.addRecipe

import core.legion.samovar.entry.EquipmentItem
import core.legion.samovar.entry.IngredientItem
import core.legion.samovar.entry.RecipePointItem
import io.reactivex.Single

class AddRecipeInteractor : AddRecipeFacade.Interactor {

    private var ingredients = arrayListOf(IngredientItem())
    private var equipments = arrayListOf(EquipmentItem())
    private var recipePoints = arrayListOf(RecipePointItem())

    override fun getIngredients(): Single<ArrayList<IngredientItem>> = Single.just(ingredients)
    override fun getEquipments(): Single<ArrayList<EquipmentItem>> = Single.just(equipments)
    override fun getRecipePoints(): Single<ArrayList<RecipePointItem>> = Single.just(recipePoints)
}
