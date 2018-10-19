package core.legion.samovar.app

import core.legion.samovar.recipe_list.RecipeListActivity
import core.legion.samovar.recipe_list.RecipeListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {
    @ContributesAndroidInjector(modules = [RecipeListModule::class])
    fun recipeListActivity(): RecipeListActivity
}