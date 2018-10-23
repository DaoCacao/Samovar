package core.legion.samovar.screens.addRecipe

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class AddRecipeModule {

    @Binds
    abstract fun view(view: AddRecipeActivity): AddRecipeFacade.View

    @Binds
    abstract fun presenter(presenter: AddRecipePresenter): AddRecipeFacade.Presenter

    @Binds
    abstract fun interactor(interactor: AddRecipeInteractor): AddRecipeFacade.Interactor

    @Binds
    abstract fun onIngredientChangeListener(presenter: AddRecipePresenter): AddRecipeFacade.OnIngredientChangeListener

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun ingredientAdapter(listener: AddRecipeFacade.OnIngredientChangeListener) = IngredientsAdapter(listener)
    }
}