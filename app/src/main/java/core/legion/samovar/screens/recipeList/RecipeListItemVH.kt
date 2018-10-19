package core.legion.samovar.screens.recipeList

import android.view.ViewGroup
import core.legion.samovar.base.BaseVH
import core.legion.samovar.R
import core.legion.samovar.entry.RecipeListItem
import kotlinx.android.synthetic.main.item_recipe_list.view.*

class RecipeListItemVH(parent: ViewGroup, private val recipeListListener: RecipeListFacade.RecipeListListener) : BaseVH<RecipeListItem>(parent, R.layout.item_recipe_list) {

    override fun bind(item: RecipeListItem) {
        itemView.tvName.text = item.name

        itemView.setOnClickListener { recipeListListener.onItemClick(item.id) }
    }
}