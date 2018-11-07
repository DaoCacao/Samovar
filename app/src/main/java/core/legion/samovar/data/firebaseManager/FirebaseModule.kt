package core.legion.samovar.data.firebaseManager

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

object FirebaseModule {
    val firebaseModule = Kodein.Module {
        bind<FirebaseApp>() with singleton { FirebaseApp.getInstance()!! }
        bind<FirebaseFirestore>() with singleton { FirebaseFirestore.getInstance(instance()) }
        bind<FirebaseStorage>() with singleton { FirebaseStorage.getInstance(instance<FirebaseApp>()) }
        bind<DBManager>() with singleton { FirebaseManager(instance(), instance()) }
    }
}