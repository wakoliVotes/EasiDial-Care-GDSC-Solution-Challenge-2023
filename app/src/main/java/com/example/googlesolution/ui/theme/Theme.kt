package com.example.googlesolution.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// TODO: Fix app theming
private val DarkColorPalette = darkColors(
    primary = Purple500,
    primaryVariant = Purple500,
    secondary = WaterDark,


    background = Color.Black,
    onPrimary = Color.White,
    onSecondary = Color.White,
    surface = Purple500,
//    surface = Color.Black,
    onSurface = Color.White,

//    onSecondary = Color.Black,
//    onBackground = Color.Black,
    /*
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    */
)

private val LightColorPalette = lightColors(
    primary = Purple700,
    primaryVariant = Purple500,
    secondary = Teal200,

    background = Color.White,
    surface = Color.White,
    //surface = Purple700,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
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

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}