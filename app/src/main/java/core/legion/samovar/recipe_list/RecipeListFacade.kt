package core.legion.samovar.recipe_list

import core.legion.samovar.base.BaseFacade
import io.reactivex.Single

interface RecipeListFacade {
    interface View : BaseFacade.View {
        fun setIds(ids: ArrayList<Long>)
    }

    interface Presenter : BaseFacade.Presenter {
        fun onRecipeClick(id: Long)
        fun getRecipeListItem(id: Long): Single<RecipeListItem>
    }

    interface Interactor : BaseFacade.Interactor {
        fun getAllRecipes(): Single<ArrayList<Long>>
        fun getRecipe(id: Long): Single<RecipeListItem>
    }

    interface RecipeListListener {
        fun onItemClick(id: Long)
        fun getItem(id: Long): Single<RecipeListItem>
    }
}