package core.legion.samovar.screens.recipeInfo

import android.os.Bundle
import android.view.View
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity
import core.legion.samovar.R
import kotlinx.android.synthetic.main.activity_recipe_info.*

class RecipeInfoActivity : KodeinAppCompatActivity(), RecipeInfoFacade.View {

    override fun provideOverridingModule() = Kodein.Module {
        bind<RecipeInfoFacade.View>() with provider { this@RecipeInfoActivity }
        bind<RecipeInfoFacade.Presenter>() with provider { RecipeInfoPresenter(instance(), instance()) }
    }

    private val presenter: RecipeInfoFacade.Presenter by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_info)

        ivApprove.setOnClickListener { presenter.onApproveClick() }
        ivDecline.setOnClickListener { presenter.onDeclineClick() }

        presenter.handleIntent(intent)
    }

    override fun closeView() = finish()

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

