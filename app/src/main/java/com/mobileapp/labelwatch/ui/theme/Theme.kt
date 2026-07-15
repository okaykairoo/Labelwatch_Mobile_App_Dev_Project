package com.mobileapp.labelwatch.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(

    primary = LabelGreenLight,

    secondary = LabelGreen,

    tertiary = WarningAmber,

    background = DarkBackground,

    surface = DarkSurface,

    error = DangerRed

)

private val LightColorScheme = lightColorScheme(

    primary = LabelGreen,

    secondary = LabelGreenDark,

    tertiary = WarningAmber,

    background = Background,

    surface = Surface,

    error = DangerRed

)

@Composable
fun LabelwatchTheme(

    darkTheme: Boolean = isSystemInDarkTheme(),

    dynamicColor: Boolean = false,

    content: @Composable () -> Unit

) {

    val colorScheme = when {

        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {

            val context = LocalContext.current

            if (darkTheme)
                dynamicDarkColorScheme(context)
            else
                dynamicLightColorScheme(context)

        }

        darkTheme -> DarkColorScheme

        else -> LightColorScheme

    }

    MaterialTheme(

        colorScheme = colorScheme,

        typography = Typography,

        content = content

    )

}