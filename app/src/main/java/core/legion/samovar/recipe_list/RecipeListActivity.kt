package core.legion.samovar.recipe_list

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import core.legion.samovar.*
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

