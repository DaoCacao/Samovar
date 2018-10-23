package core.legion.samovar.screens.addRecipe

import android.app.Activity
import android.os.Bundle
import core.legion.samovar.R
import core.legion.samovar.base.BaseActivity
import core.legion.samovar.utils.SimpleTextWatcher
import kotlinx.android.synthetic.main.activity_add_recipe.*
import android.content.Intent
import android.graphics.Bitmap
import android.support.v4.view.ViewCompat

class AddRecipeActivity : BaseActivity<AddRecipeFacade.Presenter>(), AddRecipeFacade.View {

    private val requestGallery = 69
    private val externalUri by lazy { android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        setSupportActionBar(toolbar)

        ivImage.setOnClickListener { presenter.onImageClick() }

        etName.addTextChangedListener(SimpleTextWatcher(presenter::onNameChanged))
        etDescription.addTextChangedListener(SimpleTextWatcher(presenter::onDescriptionChanged))

        rvIngredients.adapter = IngredientsAdapter()
        ViewCompat.setNestedScrollingEnabled(rvIngredients, false)
        rvEquipments.adapter = IngredientsAdapter()
        ViewCompat.setNestedScrollingEnabled(rvEquipments, false)
        rvRecipe.adapter = IngredientsAdapter()
        ViewCompat.setNestedScrollingEnabled(rvRecipe, false)

        fab.setOnClickListener { presenter.onAddClick() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK)
            when (requestCode) {
                requestGallery -> presenter.onImageFromGallery(data!!)
            }
    }

    override fun showChooseImageDialog() {
        openGallery()
    }

    override fun showImage(image: Bitmap) = ivImage.setImageBitmap(image)

    private fun openGallery() = startActivityForResult(createGalleryIntent(), requestGallery)
    private fun createGalleryIntent() = Intent(Intent.ACTION_PICK, externalUri).apply { type = "image/*" }
}

