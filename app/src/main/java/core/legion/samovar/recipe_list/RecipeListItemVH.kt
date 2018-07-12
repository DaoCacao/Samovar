package core.legion.samovar.recipe_list

import android.view.ViewGroup
import core.legion.samovar.BaseVH
import core.legion.samovar.R
import kotlinx.android.synthetic.main.item_recipe_list.view.*

class RecipeListItemVH(parent: ViewGroup, private val recipeListListener: RecipeListFacade.RecipeListListener) : BaseVH<RecipeListItem>(parent, R.layout.item_recipe_list) {

    override fun bind(item: RecipeListItem) {
        itemView.tvName.text = "id: ${item.id} name: ${item.name}"

        itemView.setOnClickListener { recipeListListener.onItemClick(item.id) }
    }
}