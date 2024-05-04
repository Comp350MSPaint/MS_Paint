package com.example.mspaint.tools

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import java.io.File
import java.lang.Exception

fun Bitmap.saveToDisk(context: Context) {
    val fileName = "test2.png"
    val filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
    val directory = File(filePath, "DoddleDoodle")
    val values = ContentValues()

    if (!directory.exists()) {
        directory.mkdirs()
    }
    val file = File(directory, fileName)

    file.writeBitmap(this, Bitmap.CompressFormat.PNG, 100)
    try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val contentValues = ContentValues().apply {
                put(MediaStore.Images.Media.DISPLAY_NAME, file.name)
                put(MediaStore.Images.Media.MIME_TYPE, "image/png")
                put(
                    MediaStore.Images.Media.RELATIVE_PATH,
                    "${Environment.DIRECTORY_PICTURES}/${directory.name}"
                )
            }
            context.contentResolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues
            )
        } else {
            context.sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)))
        }
        Toast.makeText(context, "File saved to Photos", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Failed to save file", Toast.LENGTH_SHORT).show()
    }
}

private fun File.writeBitmap(bitmap: Bitmap, format: Bitmap.CompressFormat, quality: Int) {
    outputStream().use {out->
        bitmap.compress(format,quality,out)
        out.flush()
    }
}