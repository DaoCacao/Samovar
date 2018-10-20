package core.legion.samovar.data.contentManager

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ExternalStorageManagerModule {

    @Binds
    abstract fun externalStorageManager(manager: ExternalStorageManager): ContentManager

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun contentResolver(context: Context) = context.contentResolver
    }
}