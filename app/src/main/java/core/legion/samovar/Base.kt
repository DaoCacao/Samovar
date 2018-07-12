package core.legion.samovar

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity
import java.util.*
import javax.inject.Inject

interface BaseFacade {
    interface View {
        fun showToast(text: String)
    }
    interface Presenter {
        fun onResume() {}
    }
    interface Interactor
}

abstract class BaseActivity<P : BaseFacade.Presenter> : DaggerAppCompatActivity(), BaseFacade.View {
    @Inject lateinit var presenter: P

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}

abstract class BasePresenter<V : BaseFacade.View, I : BaseFacade.Interactor> : BaseFacade.Presenter {
    @Inject lateinit var view: V
    @Inject lateinit var interactor: I
}

abstract class BaseInteractor : BaseFacade.Interactor

abstract class BaseVH<in I>(parent: ViewGroup, @LayoutRes layout: Int)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false)) {

    abstract fun bind(item: I)
}