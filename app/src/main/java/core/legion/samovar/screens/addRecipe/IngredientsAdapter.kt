package core.legion.samovar.screens.addRecipe

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import core.legion.samovar.R
import core.legion.samovar.base.BaseVH
import kotlinx.android.synthetic.main.item_ingredient.view.*

class IngredientsAdapter : RecyclerView.Adapter<IngredientsVH>() {

    var ingredients = arrayListOf(Ingredient("1123123123213"), Ingredient("1"), Ingredient("1"), Ingredient("1"))
//    var ingredients = ArrayList<Ingredient>()
    var isEditable = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsVH = IngredientsVH(parent)

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientsVH, pos: Int) {
        holder.setEditable(isEditable)
        holder.bind(ingredients[pos])
    }
}

class IngredientsVH(parent: ViewGroup) : BaseVH<Ingredient>(parent, R.layout.item_ingredient) {
    override fun bind(item: Ingredient) {
        itemView.etName.setText(item.name)
    }

    fun setEditable(isEditable: Boolean) {
        itemView.etName.isEnabled = isEditable
    }
}

class Ingredient(val name: String)