package core.legion.samovar

import android.content.Context
import core.legion.samovar.recipe_list.RecipeListActivity
import core.legion.samovar.recipe_list.RecipeListModule
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

class AppLoader : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.create()
}

@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBindingModule::class])
interface AppComponent : AndroidInjector<AppLoader>

@Module
interface AppModule {
    @Binds fun context(appLoader: AppLoader): Context
}

@Module
interface ActivityBindingModule {
    @ContributesAndroidInjector(modules = [RecipeListModule::class]) fun recipeListActivity(): RecipeListActivity
}
