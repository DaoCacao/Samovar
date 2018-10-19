package core.legion.samovar.app

import core.legion.samovar.recipeList.RecipeListActivity
import core.legion.samovar.recipeList.RecipeListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {
    @ContributesAndroidInjector(modules = [RecipeListModule::class])
    fun recipeListActivity(): RecipeListActivity
}