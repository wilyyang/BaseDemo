package com.example.basedemo.ui.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.colorResource
import com.example.basedemo.R

@Composable
fun BaseDemoTheme(content : @Composable () -> Unit) {
    val colors = Colors(
        primary = colorResource(id = R.color.main500),
        primaryVariant = colorResource(id = R.color.main500),
        secondary = colorResource(id = R.color.gray900),
        secondaryVariant = colorResource(id = R.color.main500),
        background = colorResource(id = R.color.gray100),
        surface = colorResource(id = R.color.white),
        error = colorResource(id = R.color.error_forever),
        onPrimary = colorResource(id = R.color.black_forever),
        onSecondary = colorResource(id = R.color.gray100),
        onBackground = colorResource(id = R.color.gray900),
        onSurface = colorResource(id = R.color.gray900),
        onError = colorResource(id = R.color.white),
        isSystemInDarkTheme()
    )
    MaterialTheme(
        colors = colors
    ) {
        CompositionLocalProvider(LocalRippleTheme provides BaseRippleTheme) {
            content()
        }
    }
}

@Immutable
private object BaseRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = RippleTheme.defaultRippleColor(
        contentColor = colorResource(id = R.color.gray600),
        lightTheme = true
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = colorResource(id = R.color.gray600),
        lightTheme = true
    )
}