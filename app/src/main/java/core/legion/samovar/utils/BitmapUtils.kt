package core.legion.samovar.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.reactivex.Single
import java.io.ByteArrayOutputStream
import java.io.InputStream

object BitmapUtils {

    fun getBytes(bitmap: Bitmap) = Single.just(compress(bitmap, ByteArrayOutputStream()))!!
    fun getBitmap(bytes: ByteArray) = Single.just(decode(bytes))!!
    fun getBitmap(inputStream: InputStream) = Single.just(decode(inputStream))!!

    private fun compress(bitmap: Bitmap, stream: ByteArrayOutputStream) = stream.apply { bitmap.compress(Bitmap.CompressFormat.JPEG, 100, this) }.toByteArray()
    private fun decode(bytes: ByteArray) = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    private fun decode(inputStream: InputStream) = BitmapFactory.decodeStream(inputStream)
}