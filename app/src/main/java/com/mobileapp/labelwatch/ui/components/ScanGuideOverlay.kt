package com.mobileapp.labelwatch.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.mobileapp.labelwatch.data.camera.GuideInfo

@Composable
fun ScanGuideOverlay(
    onGuideReady: (GuideInfo) -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            // Guide rectangle as percentage of canvas size
            val guideWidth = size.width * 0.85f
            val guideHeight = size.height * 0.55f

            val left = (size.width - guideWidth) / 2
            val top = (size.height - guideHeight) / 2
            val right = left + guideWidth
            val bottom = top + guideHeight

            // Provide guide info to parent
            onGuideReady(
                GuideInfo(
                    left = left / size.width,
                    top = top / size.height,
                    right = right / size.width,
                    bottom = bottom / size.height
                )
            )

            // Darken everything outside the guide
            drawRect(
                color = Color.Black.copy(alpha = 0.5f),
                topLeft = Offset.Zero,
                size = size
            )

            // Clear the guide area (make it transparent)
            drawRect(
                color = Color.Transparent,
                topLeft = Offset(left, top),
                size = androidx.compose.ui.geometry.Size(guideWidth, guideHeight)
            )

            // Draw corner markers
            val cornerLength = 50f
            val strokeWidth = 6f

            // Top-left corner
            drawLine(
                Color.White,
                Offset(left, top + cornerLength),
                Offset(left, top),
                strokeWidth = strokeWidth
            )
            drawLine(
                Color.White,
                Offset(left, top),
                Offset(left + cornerLength, top),
                strokeWidth = strokeWidth
            )

            // Top-right corner
            drawLine(
                Color.White,
                Offset(right - cornerLength, top),
                Offset(right, top),
                strokeWidth = strokeWidth
            )
            drawLine(
                Color.White,
                Offset(right, top),
                Offset(right, top + cornerLength),
                strokeWidth = strokeWidth
            )

            // Bottom-left corner
            drawLine(
                Color.White,
                Offset(left, bottom - cornerLength),
                Offset(left, bottom),
                strokeWidth = strokeWidth
            )
            drawLine(
                Color.White,
                Offset(left, bottom),
                Offset(left + cornerLength, bottom),
                strokeWidth = strokeWidth
            )

            // Bottom-right corner
            drawLine(
                Color.White,
                Offset(right - cornerLength, bottom),
                Offset(right, bottom),
                strokeWidth = strokeWidth
            )
            drawLine(
                Color.White,
                Offset(right, bottom),
                Offset(right, bottom - cornerLength),
                strokeWidth = strokeWidth
            )
        }
    }
}