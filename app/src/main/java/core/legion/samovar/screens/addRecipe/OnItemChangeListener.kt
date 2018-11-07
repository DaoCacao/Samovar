package core.legion.samovar.screens.addRecipe

interface OnItemChangeListener<I: Item> {
    fun onItemChanged(item: I)
}