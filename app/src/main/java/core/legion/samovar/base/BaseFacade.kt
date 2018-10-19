package core.legion.samovar.base

interface BaseFacade {
    interface View {
        fun showToast(text: String)
        fun closeView()
    }
    interface Presenter {
        fun onResume() {}
    }
}

