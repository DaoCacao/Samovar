package core.legion.samovar.app

import android.content.Context
import core.legion.samovar.data.FirebaseManagerModule
import dagger.Binds
import dagger.Module

@Module(includes = [FirebaseManagerModule::class])
interface AppModule {
    @Binds fun context(appLoader: AppLoader): Context
}