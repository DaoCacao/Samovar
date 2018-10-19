package core.legion.samovar.base

import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<P : BaseFacade.Presenter> : DaggerAppCompatActivity(), BaseFacade.View {

    @Inject lateinit var presenter: P

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    override fun closeView() = finish()
}