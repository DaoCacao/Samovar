package core.legion.samovar.screens.recipeInfo

import dagger.Binds
import dagger.Module

@Module
abstract class RecipeInfoModule {

    @Binds
    abstract fun view(view: RecipeInfoActivity): RecipeInfoFacade.View

    @Binds
    abstract fun presenter(presenter: RecipeInfoPresenter): RecipeInfoFacade.Presenter
}