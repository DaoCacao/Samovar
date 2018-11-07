package core.legion.samovar.screens.addRecipe

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import core.legion.samovar.entry.EquipmentItem
import core.legion.samovar.entry.IngredientItem
import core.legion.samovar.entry.RecipePointItem

abstract class BaseItemAdapter<I : Item> : RecyclerView.Adapter<BaseItemVH<I>>(), OnItemChangeListener<I> {

    var items = ArrayList<I>()

    abstract fun createItem(): I

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseItemVH<I> = BaseItemVH(parent, this)
    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: BaseItemVH<I>, pos: Int) = holder.bind(items[pos])

    override fun onItemChanged(item: I) {
        when {
            isNeedToDeleteItem(item) -> removeItem(item)
            isNeedToAddItem(item) -> addItem()
        }
    }

    private fun isNeedToDeleteItem(item: I) = item.name.isBlank() && !isItemOnLastPos(item) && !isOnlyOneItem()
    private fun isNeedToAddItem(item: I) = isItemOnLastPos(item)

    private fun isOnlyOneItem() = items.size == 1
    private fun isItemOnLastPos(item: I) = items.last() == item

    private fun removeItem(item: I) {
        val index = items.indexOf(item)
        items.remove(item)
        notifyItemRemoved(index)
    }

    private fun addItem() {
        items.add(createItem())
        notifyItemInserted(itemCount - 1)
    }

}

class IngredientsAdapter : BaseItemAdapter<IngredientItem>() {
    override fun createItem() = IngredientItem()
}

class EquipmentsAdapter : BaseItemAdapter<EquipmentItem>() {
    override fun createItem() = EquipmentItem()
}

class RecipePointsAdapter : BaseItemAdapter<RecipePointItem>() {
    override fun createItem() = RecipePointItem()
}