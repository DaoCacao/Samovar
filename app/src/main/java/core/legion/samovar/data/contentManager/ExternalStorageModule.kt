package core.legion.samovar.data.contentManager

import android.content.ContentResolver
import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

object ExternalStorageModule {
    val externalStorageModule = Kodein.Module {
        bind<ContentResolver>() with singleton { instance<Context>().contentResolver }
        bind<ContentManager>() with singleton { ExternalStorageManager(instance()) }
    }
}