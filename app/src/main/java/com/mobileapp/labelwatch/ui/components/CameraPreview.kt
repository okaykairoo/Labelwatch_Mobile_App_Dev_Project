package com.mobileapp.labelwatch.ui.components

import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.platform.LocalContext
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.core.Preview
import androidx.camera.core.CameraSelector
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.camera.core.ImageCapture
import androidx.compose.runtime.remember
import androidx.compose.runtime.LaunchedEffect
import java.io.File
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageCapture.OutputFileOptions
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.net.Uri
import com.mobileapp.labelwatch.data.camera.GuideInfo

@Composable
fun CameraPreview(
    modifier: Modifier = Modifier,
    captureRequest: Int,
    guideRect: GuideInfo? = null,  // Added: guide rectangle info
    onImageCaptured: (android.net.Uri) -> Unit,
    onError: (Exception) -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val imageCapture = remember {
        ImageCapture.Builder().build()
    }

    AndroidView(
        modifier = modifier,
        factory = { ctx ->
            val previewView = PreviewView(ctx)
            val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)

            cameraProviderFuture.addListener({
                val cameraProvider = cameraProviderFuture.get()
                val preview = Preview.Builder().build()
                preview.surfaceProvider = previewView.surfaceProvider

                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    CameraSelector.DEFAULT_BACK_CAMERA,
                    preview,
                    imageCapture
                )
            }, ContextCompat.getMainExecutor(ctx))

            previewView
        }
    )

    LaunchedEffect(captureRequest) {
        if (captureRequest > 0) {
            val photoFile = File(
                context.cacheDir,
                "labelwatch_${
                    SimpleDateFormat(
                        "yyyyMMdd_HHmmss",
                        Locale.getDefault()
                    ).format(Date())
                }.jpg"
            )

            val outputOptions = OutputFileOptions.Builder(photoFile).build()

            imageCapture.takePicture(
                outputOptions,
                ContextCompat.getMainExecutor(context),
                object : ImageCapture.OnImageSavedCallback {
                    override fun onImageSaved(
                        outputFileResults: ImageCapture.OutputFileResults
                    ) {
                        // If guide rect is provided, crop the image
                        val finalUri = if (guideRect != null) {
                            cropImageToGuide(context, photoFile, guideRect)
                        } else {
                            Uri.fromFile(photoFile)
                        }

                        // Delete original file if cropped
                        if (guideRect != null && photoFile.exists()) {
                            photoFile.delete()
                        }

                        onImageCaptured(finalUri ?: Uri.fromFile(photoFile))
                    }

                    override fun onError(exception: ImageCaptureException) {
                        onError(exception)
                    }
                }
            )
        }
    }
}

// Helper function to crop image to guide rectangle
private fun cropImageToGuide(
    context: android.content.Context,
    file: File,
    guideRect: GuideInfo
): Uri? {
    return try {
        val bitmap = BitmapFactory.decodeFile(file.absolutePath)
        if (bitmap == null) return null

        val width = bitmap.width
        val height = bitmap.height

        // Convert percentage-based guide to pixel coordinates
        val left = (width * guideRect.left).toInt().coerceAtLeast(0)
        val top = (height * guideRect.top).toInt().coerceAtLeast(0)
        val right = (width * guideRect.right).toInt().coerceAtMost(width)
        val bottom = (height * guideRect.bottom).toInt().coerceAtMost(height)

        // Only crop if the guide area is valid
        if (right <= left || bottom <= top) {
            return null
        }

        val croppedBitmap = Bitmap.createBitmap(
            bitmap,
            left,
            top,
            right - left,
            bottom - top
        )

        // Save cropped bitmap
        val croppedFile = File(
            context.cacheDir,
            "cropped_${System.currentTimeMillis()}.jpg"
        )

        java.io.FileOutputStream(croppedFile).use { outputStream ->
            croppedBitmap.compress(
                Bitmap.CompressFormat.JPEG,
                95,
                outputStream
            )
        }

        Uri.fromFile(croppedFile)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}