package core.legion.samovar.recipe_list

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RecipeListModule {
    @Binds abstract fun view(view: RecipeListActivity): RecipeListFacade.View
    @Binds abstract fun presenter(presenter: RecipeListPresenter): RecipeListFacade.Presenter
    @Binds abstract fun interactor(interactor: RecipeListInteractor): RecipeListFacade.Interactor
    @Binds abstract fun recipeListListener(view: RecipeListActivity): RecipeListFacade.RecipeListListener

    @Module
    companion object {
        @JvmStatic @Provides fun adapter(recipeListListener: RecipeListFacade.RecipeListListener) = RecipeListAdapter(recipeListListener)
    }
}

