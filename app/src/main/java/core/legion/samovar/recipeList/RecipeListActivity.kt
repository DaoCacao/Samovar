package core.legion.samovar.recipeList

import android.os.Bundle
import core.legion.samovar.*
import core.legion.samovar.base.BaseActivity
import io.reactivex.Single
import kotlinx.android.synthetic.main.activity_recipe_list.*
import javax.inject.Inject

class RecipeListActivity : BaseActivity<RecipeListFacade.Presenter>(), RecipeListFacade.View, RecipeListFacade.RecipeListListener {

    @Inject lateinit var adapter: RecipeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        rvRecipes.adapter = adapter
    }

    override fun setIds(ids: ArrayList<Long>) {
        adapter.ids = ids
    }

    override fun onItemClick(id: Long) {
        presenter.onRecipeClick(id)
    }

    override fun getItem(id: Long): Single<RecipeListItem> = presenter.getRecipeListItem(id)
}

