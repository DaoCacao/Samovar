package core.legion.samovar.data.contentManager

import android.content.ContentResolver
import android.graphics.Bitmap
import android.net.Uri
import core.legion.samovar.utils.BitmapUtils
import io.reactivex.Single

class ExternalStorageManager(private val contentResolver: ContentResolver) : ContentManager {

    override fun getImageFromUri(uri: Uri): Single<Bitmap> {
        return Single.just(contentResolver.openInputStream(uri))
                .flatMap { BitmapUtils.getBitmap(it) }
    }
}