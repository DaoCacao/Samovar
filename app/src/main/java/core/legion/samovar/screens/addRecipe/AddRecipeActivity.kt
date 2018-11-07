package core.legion.samovar.screens.addRecipe

import android.app.Activity
import android.os.Bundle
import core.legion.samovar.R
import core.legion.samovar.utils.SimpleTextWatcher
import android.content.Intent
import android.graphics.Bitmap
import android.support.v4.view.ViewCompat
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity
import core.legion.samovar.entry.IngredientItem
import kotlinx.android.synthetic.main.activity_add_recipe.*

class AddRecipeActivity : KodeinAppCompatActivity(), AddRecipeFacade.View {

    override fun provideOverridingModule() = Kodein.Module {
        bind<AddRecipeFacade.View>() with provider { this@AddRecipeActivity }
        bind<AddRecipePresenter>() with singleton { AddRecipePresenter(instance(), instance(), instance(), instance()) }
        bind<AddRecipeFacade.Presenter>() with provider { instance<AddRecipePresenter>() }
        bind<AddRecipeFacade.OnIngredientChangeListener>() with provider { instance<AddRecipePresenter>() }
        bind<AddRecipeFacade.Interactor>() with provider { AddRecipeInteractor() }
        bind<IngredientsAdapter>() with provider { IngredientsAdapter(instance()) }
    }

    private val presenter: AddRecipeFacade.Presenter by instance()
    private val ingredientsAdapter: IngredientsAdapter by instance()

    private val requestGallery = 69
    private val externalUri by lazy { android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        setSupportActionBar(toolbar)

        ivImage.setOnClickListener { presenter.onImageClick() }

        etName.addTextChangedListener(SimpleTextWatcher(presenter::onNameChanged))
        etDescription.addTextChangedListener(SimpleTextWatcher(presenter::onDescriptionChanged))

        rvIngredients.adapter = ingredientsAdapter
        ViewCompat.setNestedScrollingEnabled(rvIngredients, false)

        rvEquipments.adapter = ingredientsAdapter
        ViewCompat.setNestedScrollingEnabled(rvEquipments, false)

        rvRecipe.adapter = ingredientsAdapter
        ViewCompat.setNestedScrollingEnabled(rvRecipe, false)

        fab.setOnClickListener { presenter.onAddClick() }

        presenter.onViewInit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK)
            when (requestCode) {
                requestGallery -> presenter.onImageFromGallery(data!!)
            }
    }

    override fun showImage(image: Bitmap) = ivImage.setImageBitmap(image)
    override fun showIngredients(ingredients: ArrayList<IngredientItem>) {
        ingredientsAdapter.ingredients = ingredients
        ingredientsAdapter.notifyDataSetChanged()
    }

    override fun closeView() = finish()

    override fun showChooseImageDialog() {
        openGallery()
    }

    override fun notifyIngredientAdded(pos: Int) = ingredientsAdapter.notifyItemInserted(pos)
    override fun notifyIngredientRemoved(pos: Int) = ingredientsAdapter.notifyItemRemoved(pos)

    private fun openGallery() = startActivityForResult(createGalleryIntent(), requestGallery)
    private fun createGalleryIntent() = Intent(Intent.ACTION_PICK, externalUri).apply { type = "image/*" }
}

