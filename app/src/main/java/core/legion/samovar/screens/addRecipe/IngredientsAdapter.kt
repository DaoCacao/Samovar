package core.legion.samovar.screens.addRecipe

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import core.legion.samovar.entry.IngredientItem

class IngredientsAdapter(private val listener: AddRecipeFacade.OnIngredientChangeListener) : RecyclerView.Adapter<IngredientsVH>() {

    var ingredients = ArrayList<IngredientItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsVH = IngredientsVH(parent, listener)

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientsVH, pos: Int) {
        holder.bind(ingredients[pos])
    }
}

