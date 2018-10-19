package core.legion.samovar.app

import core.legion.samovar.screens.recipeList.RecipeListActivity
import core.legion.samovar.screens.recipeList.RecipeListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {
    @ContributesAndroidInjector(modules = [RecipeListModule::class])
    fun recipeListActivity(): RecipeListActivity
}