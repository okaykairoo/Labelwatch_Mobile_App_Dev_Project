package com.mobileapp.labelwatch.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.content.Context
import java.io.File
import java.io.FileOutputStream

object ImageCropper {

    /**
     * Crop a bitmap to the specified rectangle area
     */
    fun cropBitmap(
        bitmap: Bitmap,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ): Bitmap {
        // Ensure coordinates are within bounds
        val cropLeft = left.coerceAtLeast(0)
        val cropTop = top.coerceAtLeast(0)
        val cropRight = right.coerceAtMost(bitmap.width)
        val cropBottom = bottom.coerceAtMost(bitmap.height)

        val width = cropRight - cropLeft
        val height = cropBottom - cropTop

        // Return the cropped region
        return Bitmap.createBitmap(
            bitmap,
            cropLeft,
            cropTop,
            width,
            height
        )
    }

    /**
     * Crop image from URI and save to a new file
     */
    fun cropAndSaveImage(
        context: Context,
        imageUri: Uri,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ): Uri? {
        return try {
            // Load the bitmap from URI
            val bitmap = BitmapFactory.decodeStream(
                context.contentResolver.openInputStream(imageUri)
            )

            if (bitmap == null) return null

            // Crop the bitmap
            val croppedBitmap = cropBitmap(bitmap, left, top, right, bottom)

            // Save cropped bitmap to a temporary file
            val croppedFile = File(
                context.cacheDir,
                "cropped_${System.currentTimeMillis()}.jpg"
            )

            FileOutputStream(croppedFile).use { outputStream ->
                croppedBitmap.compress(
                    Bitmap.CompressFormat.JPEG,
                    95,
                    outputStream
                )
            }

            // Return URI of cropped image
            Uri.fromFile(croppedFile)

        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}