package com.example.googlesolution.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColors(
    primary = Purple80,
    secondary = PurpleGrey80,
)

private val LightColorPalette = lightColors(
    primary = Purple40,
    secondary = PurpleGrey40,

    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
)

@Composable
fun GoogleSolutionTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    // This code manages the color of the status bar
    ///Start
    val activity = LocalView.current.context as Activity
    val backgroundArgb = colors.surface.toArgb()
    activity.window?.statusBarColor = backgroundArgb

    val wic = WindowCompat.getInsetsController(activity.window, activity.window.decorView)
    wic.isAppearanceLightStatusBars = !darkTheme
    ///Stop

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}