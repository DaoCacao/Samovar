package core.legion.samovar.screens.addRecipe

import dagger.Binds
import dagger.Module

@Module
abstract class AddRecipeModule {

    @Binds
    abstract fun view(view: AddRecipeActivity): AddRecipeFacade.View

    @Binds
    abstract fun presenter(presenter: AddRecipePresenter): AddRecipeFacade.Presenter
}