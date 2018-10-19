package core.legion.samovar.app

import android.content.Context
import dagger.Binds
import dagger.Module

@Module
interface AppModule {
    @Binds fun context(appLoader: AppLoader): Context
}