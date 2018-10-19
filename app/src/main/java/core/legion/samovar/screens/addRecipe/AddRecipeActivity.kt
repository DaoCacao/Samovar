package core.legion.samovar.screens.addRecipe

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import core.legion.samovar.R
import core.legion.samovar.base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_recipe.*

class AddRecipeActivity : BaseActivity<AddRecipeFacade.Presenter>(), AddRecipeFacade.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        etName.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) = presenter.onNameChanged(s.toString())
        })
        etDescription.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) = presenter.onDescriptionChanged(s.toString())
        })

        ivAdd.setOnClickListener { presenter.onAddClick() }
    }
}

abstract class SimpleTextWatcher : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
}