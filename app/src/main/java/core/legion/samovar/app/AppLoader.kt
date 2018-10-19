package core.legion.samovar.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class AppLoader : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}

