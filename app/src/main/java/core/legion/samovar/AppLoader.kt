package core.legion.samovar

import android.app.Application
import android.content.Context
import com.github.salomonbrys.kodein.*

class AppLoader : Application(), KodeinAware {

    override val kodein: Kodein by Kodein.lazy {
        bind<Context>() with singleton { applicationContext }
    }
}

