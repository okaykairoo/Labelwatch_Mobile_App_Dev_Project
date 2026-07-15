package com.mobileapp.labelwatch.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mobileapp.labelwatch.domain.IngredientMatcher
import com.mobileapp.labelwatch.domain.ProductAnalyzer
import com.mobileapp.labelwatch.domain.TextCleaner
import com.mobileapp.labelwatch.ocr.OcrProcessor
import com.mobileapp.labelwatch.session.OcrSession
import com.mobileapp.labelwatch.session.ScanSession
import com.mobileapp.labelwatch.ui.components.CameraPermission
import com.mobileapp.labelwatch.ui.components.CameraPreview
import com.mobileapp.labelwatch.ui.components.PrimaryButton
import com.mobileapp.labelwatch.ui.components.ProcessingOverlay
import com.mobileapp.labelwatch.ui.components.ScanGuideOverlay
import com.mobileapp.labelwatch.ui.screens.history.HistoryManager
import com.mobileapp.labelwatch.data.camera.GuideInfo
import com.mobileapp.labelwatch.R

@Composable
fun ScanScreen(
    navController: NavHostController
) {

    var captureRequest by remember { mutableStateOf(0) }

    var isProcessing by remember { mutableStateOf(false) }

    var processingMessage by remember { mutableStateOf("") }

    var guideInfo by remember { mutableStateOf<GuideInfo?>(null) }

    val context = LocalContext.current

    val ocrProcessor = remember {
        OcrProcessor()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.logo_transparent),
            contentDescription = "labelwatch logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Fit
        )



        Spacer(modifier = Modifier.height(4.dp))



        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Align the ingredient list inside the guide.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Camera Section
        CameraPermission {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4f / 3f),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {

                    CameraPreview(

                        modifier = Modifier.fillMaxSize(),

                        captureRequest = captureRequest,

                        guideRect = guideInfo,  // Pass guide info for cropping

                        onImageCaptured = { uri ->

                            isProcessing = true
                            processingMessage = "Reading label..."

                            ocrProcessor.processImage(

                                context = context,
                                imageUri = uri,

                                onSuccess = { detectedText ->

                                    processingMessage = "Analyzing ingredients..."

                                    val cleanedText =
                                        TextCleaner.clean(detectedText)

                                    val matchResult =
                                        IngredientMatcher.matchIngredients(cleanedText)

                                    val analysis =
                                        ProductAnalyzer.analyze(matchResult)

                                    OcrSession.latestText = detectedText

                                    HistoryManager.addScan(analysis)

                                    ScanSession.latestAnalysis = analysis

                                    Log.d(
                                        "LABELWATCH_SCORE",
                                        analysis.toString()
                                    )

                                    isProcessing = false

                                    navController.navigate("results")

                                },

                                onFailure = {

                                    isProcessing = false

                                    it.printStackTrace()

                                }

                            )

                        },

                        onError = {

                            isProcessing = false

                        }

                    )

                    // Overlay with guide info callback
                    ScanGuideOverlay(
                        onGuideReady = { guide ->
                            guideInfo = guide
                        }
                    )

                }
            }



        }

        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(

            text = "Capture & Analyze",

            onClick = {

                captureRequest++

            }

        )

    }

    if (isProcessing) {

        ProcessingOverlay(

            message = processingMessage

        )

    }

}