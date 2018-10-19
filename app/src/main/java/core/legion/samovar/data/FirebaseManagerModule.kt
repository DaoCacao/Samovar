package core.legion.samovar.data

import dagger.Binds
import dagger.Module

@Module
interface FirebaseManagerModule {

    @Binds
    fun firebaseManager(manager: FirebaseManager): DBManager
}