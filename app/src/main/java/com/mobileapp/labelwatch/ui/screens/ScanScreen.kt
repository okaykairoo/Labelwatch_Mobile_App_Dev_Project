package com.mobileapp.labelwatch.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import com.mobileapp.labelwatch.ui.components.CameraPermission
import com.mobileapp.labelwatch.ui.components.CameraPreview
import com.mobileapp.labelwatch.ui.components.PrimaryButton
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext


@Composable
fun ScanScreen() {

    var captureRequest by remember {
        mutableStateOf(0)
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //Top
        Column {
            Text(
                text = "Labelwatch",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Scan. Understand. Decide",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(20.dp))


        }

        CameraPermission {
            CameraPreview(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),

                captureRequest = captureRequest,
                onImageCaptured = { uri ->
                    //ocr logic
                    Toast.makeText(
                        context,
                        "Photo Captured!",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                onError = {
                    //show bar
                }
            )
        }

        PrimaryButton(
            text = "Scan label",
            onClick ={
                captureRequest++
            }
        )
        
    }
}