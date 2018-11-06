package core.legion.samovar.screens.recipeList

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.AndroidInjector
import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity
import core.legion.samovar.*
import core.legion.samovar.base.BaseActivity
import core.legion.samovar.entry.RecipeListItem
import core.legion.samovar.screens.addRecipe.AddRecipeActivity
import core.legion.samovar.screens.recipeInfo.RecipeInfoActivity
import core.legion.samovar.utils.Helper
import kotlinx.android.synthetic.main.activity_recipe_list.*
import javax.inject.Inject

class RecipeListActivity : KodeinAppCompatActivity(), RecipeListFacade.View {

    override fun provideOverridingModule(): Kodein.Module = Kodein.Module {
        bind<RecipeListFacade.View>() with provider { this@RecipeListActivity }
        bind<RecipeListFacade.Presenter>() with provider { RecipeListPresenter(instance(), instance()) }
        bind<RecipeListFacade.Interactor>() with provider { RecipeListInteractor() }
        bind<RecipeListAdapter>() with provider { RecipeListAdapter(instance()) }
    }

    enum class State {
        Loading,
        Empty,
        Recipes
    }

    private var adapter: RecipeListAdapter by kodein().getValue()

    private val layoutManager = GridLayoutManager(this, 2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        setSupportActionBar(toolbar)

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


    override fun showLoading() = changeState(State.Loading)

    override fun showListEmpty() = changeState(State.Empty)

    override fun showRecipes(recipes: ArrayList<RecipeListItem>) {
        changeState(State.Recipes)
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

    private fun changeState(state: State) {
        rvRecipes.visibility = if (state == State.Recipes) View.VISIBLE else View.GONE
        pbLoading.visibility = if (state == State.Loading) View.VISIBLE else View.GONE
        tvNoRecipes.visibility = if (state == State.Empty) View.VISIBLE else View.GONE
    }
}

