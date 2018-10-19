package core.legion.samovar.screens.recipeList

import core.legion.samovar.base.BaseFacade
import core.legion.samovar.entry.RecipeListItem

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