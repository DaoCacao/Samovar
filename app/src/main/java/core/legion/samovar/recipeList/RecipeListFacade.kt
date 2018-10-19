package core.legion.samovar.recipeList

import core.legion.samovar.base.BaseFacade
import io.reactivex.Single

interface RecipeListFacade {
    interface View : BaseFacade.View {
        fun setRecipes(recipes: ArrayList<RecipeListItem>)
    }

    interface Presenter : BaseFacade.Presenter {
    }

    interface RecipeListListener {
        fun onItemClick(id: String)
    }
}