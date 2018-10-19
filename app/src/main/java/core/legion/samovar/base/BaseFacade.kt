package core.legion.samovar.base

interface BaseFacade {
    interface View {
        fun showToast(text: String)
    }
    interface Presenter {
        fun onResume() {}
    }
}

