package core.legion.samovar.screens.addRecipe

import android.content.Intent
import android.graphics.Bitmap
import core.legion.samovar.entry.EquipmentItem
import core.legion.samovar.entry.IngredientItem
import core.legion.samovar.entry.RecipePointItem
import io.reactivex.Single

interface AddRecipeFacade {

    interface View {
        fun showImage(image: Bitmap)
        fun showIngredients(ingredients: ArrayList<IngredientItem>)
        fun showEquipments(equipments: ArrayList<EquipmentItem>)
        fun showRecipePoints(recipePoints: ArrayList<RecipePointItem>)

        fun closeView()

        fun showChooseImageDialog()

        fun notifyIngredientAdded(pos: Int)
        fun notifyIngredientRemoved(pos: Int)

        fun notifyEquipmentAdded(pos: Int)
        fun notifyEquipmentRemoved(pos: Int)

        fun notifyRecipePointAdded(pos: Int)
        fun notifyRecipePointRemoved(pos: Int)
    }

    interface Presenter {
        fun onViewInit()

        fun onNameChanged(name: String)
        fun onDescriptionChanged(description: String)

        fun onImageClick()
        fun onAddClick()

        fun onImageFromGallery(data: Intent)
    }

    interface Interactor {
        fun getIngredients(): Single<ArrayList<IngredientItem>>
        fun getEquipments(): Single<ArrayList<EquipmentItem>>
        fun getRecipePoints(): Single<ArrayList<RecipePointItem>>
    }
}