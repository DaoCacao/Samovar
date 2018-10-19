package core.legion.samovar.base

import javax.inject.Inject

abstract class BasePresenter<V : BaseFacade.View, I : BaseFacade.Interactor> : BaseFacade.Presenter {
    @Inject lateinit var view: V
    @Inject lateinit var interactor: I
}