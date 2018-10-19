package core.legion.samovar.screens.recipeInfo

import android.os.Bundle
import core.legion.samovar.R
import core.legion.samovar.base.BaseActivity
import kotlinx.android.synthetic.main.activity_recipe_info.*

class RecipeInfoActivity : BaseActivity<RecipeInfoFacade.Presenter>(), RecipeInfoFacade.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_info)

        presenter.handleIntent(intent)
    }

    override fun showName(name: String) {
        tvName.text = name
    }

    override fun showDescription(description: String) {
        tvDescription.text = description
    }
}

