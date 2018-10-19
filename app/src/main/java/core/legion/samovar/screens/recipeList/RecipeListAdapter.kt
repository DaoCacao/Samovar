package core.legion.samovar.screens.recipeList

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class RecipeListAdapter(private val recipeListListener: RecipeListFacade.RecipeListListener) : RecyclerView.Adapter<RecipeListItemVH>() {

    var recipes: ArrayList<RecipeListItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecipeListItemVH(parent, recipeListListener)

    override fun getItemCount() = recipes.size

    override fun onBindViewHolder(holder: RecipeListItemVH, position: Int) = holder.bind(recipes[position])
}

