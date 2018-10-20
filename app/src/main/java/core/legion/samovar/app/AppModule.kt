package core.legion.samovar.app

import android.content.Context
import core.legion.samovar.data.contentManager.ExternalStorageManagerModule
import core.legion.samovar.data.firebaseManager.FirebaseManagerModule
import dagger.Module
import dagger.Provides

@Module(includes = [FirebaseManagerModule::class, ExternalStorageManagerModule::class])
class AppModule(private val context: Context) {

    @Provides
    fun context() = context
}