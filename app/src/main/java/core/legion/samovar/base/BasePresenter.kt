package core.legion.samovar.base

import javax.inject.Inject

abstract class BasePresenter<V : BaseFacade.View> : BaseFacade.Presenter {
    @Inject lateinit var view: V
}