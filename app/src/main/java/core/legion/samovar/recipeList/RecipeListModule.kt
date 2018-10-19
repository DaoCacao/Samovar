package core.legion.samovar.recipeList

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RecipeListModule {
    @Binds abstract fun view(view: RecipeListActivity): RecipeListFacade.View
    @Binds abstract fun presenter(presenter: RecipeListPresenter): RecipeListFacade.Presenter
    @Binds abstract fun recipeListListener(presenter: RecipeListPresenter): RecipeListFacade.RecipeListListener

    @Module
    companion object {
        @JvmStatic @Provides fun adapter(recipeListListener: RecipeListFacade.RecipeListListener) = RecipeListAdapter(recipeListListener)
    }
}

