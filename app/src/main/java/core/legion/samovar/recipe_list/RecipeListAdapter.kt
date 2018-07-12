package core.legion.samovar.recipe_list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class RecipeListAdapter(private val recipeListListener: RecipeListFacade.RecipeListListener) : RecyclerView.Adapter<RecipeListItemVH>() {

    var ids: ArrayList<Long> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecipeListItemVH(parent, recipeListListener)

    override fun getItemCount() = ids.size

    override fun onBindViewHolder(holder: RecipeListItemVH, position: Int) {
        recipeListListener
                .getItem(ids[position])
                .subscribe(holder::bind)
    }
}

