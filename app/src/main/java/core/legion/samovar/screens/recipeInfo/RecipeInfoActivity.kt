package core.legion.samovar.screens.recipeInfo

import android.os.Bundle
import android.transition.Visibility
import android.view.View
import core.legion.samovar.R
import core.legion.samovar.base.BaseActivity
import kotlinx.android.synthetic.main.activity_recipe_info.*

class RecipeInfoActivity : BaseActivity<RecipeInfoFacade.Presenter>(), RecipeInfoFacade.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_info)

        ivApprove.setOnClickListener { presenter.onApproveClick() }
        ivDecline.setOnClickListener { presenter.onDeclineClick() }

        presenter.handleIntent(intent)
    }

    override fun hideModerationButtons() {
        ivApprove.visibility = View.GONE
        ivDecline.visibility = View.GONE
    }

    override fun showName(name: String) {
        tvName.text = name
    }

    override fun showDescription(description: String) {
        tvDescription.text = description
    }
}

