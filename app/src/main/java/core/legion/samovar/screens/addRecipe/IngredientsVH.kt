package core.legion.samovar.screens.addRecipe

import android.view.ViewGroup
import core.legion.samovar.R
import core.legion.samovar.base.BaseVH
import core.legion.samovar.entry.IngredientItem
import core.legion.samovar.utils.SimpleTextWatcher
import kotlinx.android.synthetic.main.item_ingredient.view.*

class IngredientsVH(parent: ViewGroup, private val listener: AddRecipeFacade.OnIngredientChangeListener) : BaseVH<IngredientItem>(parent, R.layout.item_ingredient) {
    override fun bind(item: IngredientItem) {
        itemView.etName.setText(item.name)
        itemView.etName.addTextChangedListener(SimpleTextWatcher { text -> listener.onIngredientChange(adapterPosition, text)})
    }
}