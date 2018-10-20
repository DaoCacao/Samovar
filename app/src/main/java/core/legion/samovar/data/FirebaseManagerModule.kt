package core.legion.samovar.data

import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class FirebaseManagerModule {

    @Binds
    abstract fun firebaseManager(manager: FirebaseManager): DBManager

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun firebaseApp(): FirebaseApp {
            return FirebaseApp.getInstance()!!
        }

        @JvmStatic
        @Provides
        fun firebaseFirestore(firebaseApp: FirebaseApp): FirebaseFirestore {
            return FirebaseFirestore.getInstance(firebaseApp)
        }

        @JvmStatic
        @Provides
        fun firebaseStorage(firebaseApp: FirebaseApp): FirebaseStorage {
            return FirebaseStorage.getInstance(firebaseApp)
        }
    }
}
