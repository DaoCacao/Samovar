package core.legion.samovar

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import com.github.salomonbrys.kodein.*
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import core.legion.samovar.data.contentManager.ContentManager
import core.legion.samovar.data.contentManager.ExternalStorageManager
import core.legion.samovar.data.firebaseManager.DBManager
import core.legion.samovar.data.firebaseManager.FirebaseManager

class AppLoader : Application(), KodeinAware {

    override val kodein: Kodein by Kodein.lazy {
        import(firebaseModule)
        import(externalStorageModule)
    }

    private val firebaseModule = Kodein.Module {
        bind<FirebaseApp>() with singleton { FirebaseApp.getInstance()!! }
        bind<FirebaseFirestore>() with singleton { FirebaseFirestore.getInstance(instance()) }
        bind<FirebaseStorage>() with singleton { FirebaseStorage.getInstance(instance<FirebaseApp>()) }
        bind<DBManager>() with singleton { FirebaseManager(instance(), instance()) }
    }

    private val externalStorageModule = Kodein.Module {
        bind<ContentResolver>() with singleton { instance<Context>().contentResolver }
        bind<ContentManager>() with singleton { ExternalStorageManager(instance()) }
    }
}

