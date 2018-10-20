package core.legion.samovar.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.reactivex.Single
import java.io.ByteArrayOutputStream

object BitmapUtils {

    fun getBytes(bitmap: Bitmap) = Single.just(compress(bitmap, ByteArrayOutputStream()))!!
    fun getBitmap(bytes: ByteArray) = Single.just(decode(bytes))!!

    private fun compress(bitmap: Bitmap, stream: ByteArrayOutputStream): ByteArray {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }
    private fun decode(bytes: ByteArray) = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}