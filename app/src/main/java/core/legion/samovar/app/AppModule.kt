package core.legion.samovar.app

import android.content.Context
import core.legion.samovar.data.FirebaseManagerModule
import dagger.Module
import dagger.Provides

@Module(includes = [FirebaseManagerModule::class])
class AppModule(private val context: Context) {

    @Provides
    fun context() = context
}