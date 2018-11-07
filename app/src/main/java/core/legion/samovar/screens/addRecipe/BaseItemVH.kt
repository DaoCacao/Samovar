package core.legion.samovar.screens.addRecipe

import android.view.ViewGroup
import core.legion.samovar.R
import core.legion.samovar.base.BaseVH
import core.legion.samovar.utils.SimpleTextWatcher
import kotlinx.android.synthetic.main.item_base_item.view.*

class BaseItemVH<I: Item>(parent: ViewGroup, private val listener: OnItemChangeListener<I>) : BaseVH<I>(parent, R.layout.item_base_item) {

    private lateinit var textWatcher: SimpleTextWatcher

    override fun bind(item: I) {

        if (::textWatcher.isInitialized) itemView.etName.removeTextChangedListener(textWatcher)

        itemView.etName.setText(item.name)

        textWatcher = SimpleTextWatcher { text ->
            item.name = text
            listener.onItemChanged(item)
        }

        itemView.etName.addTextChangedListener(textWatcher)
    }
}