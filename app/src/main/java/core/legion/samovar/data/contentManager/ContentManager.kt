package core.legion.samovar.data.contentManager

import android.graphics.Bitmap
import android.net.Uri
import io.reactivex.Single

interface ContentManager {
    fun getImageFromUri(uri: Uri): Single<Bitmap>
}

