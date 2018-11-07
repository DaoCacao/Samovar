package core.legion.samovar

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy
import core.legion.samovar.data.contentManager.ExternalStorageModule
import core.legion.samovar.data.firebaseManager.FirebaseModule

class AppLoader : Application(), KodeinAware {

    override val kodein: Kodein by Kodein.lazy {
        import(FirebaseModule.firebaseModule)
        import(ExternalStorageModule.externalStorageModule)
    }
}

