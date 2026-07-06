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



@Composable
fun CameraPreview(
    modifier: Modifier = Modifier,
    captureRequest: Int,
    onImageCaptured: (android.net.Uri) -> Unit,
    onError: (Exception) -> Unit
){
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val imageCapture = remember {
        ImageCapture.Builder().build()
    }
    AndroidView (
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
            //image capture logic
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
                        onImageCaptured(photoFile.toURI().let{
                            android.net.Uri.fromFile(photoFile)
                        })
                    }
                    override fun onError(
                        exception: ImageCaptureException
                    ) {
                        onError(exception)
                    }
                }
            )

        }
    }
}