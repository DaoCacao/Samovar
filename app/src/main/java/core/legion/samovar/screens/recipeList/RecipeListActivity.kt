package core.legion.samovar.screens.recipeList

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import core.legion.samovar.*
import core.legion.samovar.base.BaseActivity
import core.legion.samovar.entry.RecipeListItem
import core.legion.samovar.screens.addRecipe.AddRecipeActivity
import core.legion.samovar.screens.recipeInfo.RecipeInfoActivity
import core.legion.samovar.utils.Helper
import kotlinx.android.synthetic.main.activity_recipe_list.*
import java.util.*
import javax.inject.Inject

class RecipeListActivity : BaseActivity<RecipeListFacade.Presenter>(), RecipeListFacade.View {

    @Inject lateinit var adapter: RecipeListAdapter

    private val layoutManager = GridLayoutManager(this, 2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        rvRecipes.adapter = adapter
        rvRecipes.layoutManager = layoutManager

        presenter.onViewInit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_recipe_list, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add -> navigateToAddRecipeScreen()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setRecipes(recipes: ArrayList<RecipeListItem>) {
        adapter.recipes = recipes
        adapter.notifyDataSetChanged()
    }

    override fun navigateToRecipeInfo(id: String) {
        Intent(this, RecipeInfoActivity::class.java).apply {
            putExtra(Helper.IntentExtra.RECIPE_ID, id)
            startActivity(this)
        }
    }

    private fun navigateToAddRecipeScreen() = startActivity(Intent(this, AddRecipeActivity::class.java))
}

