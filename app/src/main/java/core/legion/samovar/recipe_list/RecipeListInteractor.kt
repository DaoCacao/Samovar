package core.legion.samovar.recipe_list

import core.legion.samovar.BaseInteractor
import io.reactivex.Single
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class RecipeListInteractor @Inject constructor() : BaseInteractor(), RecipeListFacade.Interactor {

    private val ids by lazy {
        ArrayList<Long>().apply { addAll((0 until 1000000).map { it.toLong() }) }
    }

    override fun getAllRecipes(): Single<ArrayList<Long>> {
        return Single.just(ids)
    }

    override fun getRecipe(id: Long): Single<RecipeListItem> {
        return Single.just(RecipeListItem(id, "Recipe ${Random().nextInt(1000)}"))
    }
}