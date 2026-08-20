package com.tefsir.app.core.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

/** Additional brand tokens not covered by Material3's ColorScheme (gradient, muted, card surface). */
data class TefsirExtendedColors(
    val gradientStart: androidx.compose.ui.graphics.Color,
    val gradientEnd: androidx.compose.ui.graphics.Color,
    val brandPrimaryMuted: androidx.compose.ui.graphics.Color,
    val surfaceCard: androidx.compose.ui.graphics.Color,
)

private val LocalTefsirExtendedColors = staticCompositionLocalOf {
    TefsirExtendedColors(
        gradientStart = TefsirColors.BrandGradientStartLight,
        gradientEnd = TefsirColors.BrandGradientEndLight,
        brandPrimaryMuted = TefsirColors.BrandPrimaryMutedLight,
        surfaceCard = TefsirColors.SurfaceCardLight,
    )
}

val MaterialTheme.tefsirColors: TefsirExtendedColors
    @Composable get() = LocalTefsirExtendedColors.current

/**
 * Deliberately does not opt into Android 12+ dynamic color: the emerald-green
 * brand identity should read the same on every device, matching iOS which
 * doesn't adopt the system accent color either.
 */
@Composable
fun TefsirTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = TefsirColors.BrandPrimaryDark,
            secondaryContainer = TefsirColors.BrandPrimaryMutedDark,
            surfaceVariant = TefsirColors.SurfaceCardDark,
        )
    } else {
        lightColorScheme(
            primary = TefsirColors.BrandPrimaryLight,
            secondaryContainer = TefsirColors.BrandPrimaryMutedLight,
            surfaceVariant = TefsirColors.SurfaceCardLight,
        )
    }

    val extendedColors = if (darkTheme) {
        TefsirExtendedColors(
            gradientStart = TefsirColors.BrandGradientStartDark,
            gradientEnd = TefsirColors.BrandGradientEndDark,
            brandPrimaryMuted = TefsirColors.BrandPrimaryMutedDark,
            surfaceCard = TefsirColors.SurfaceCardDark,
        )
    } else {
        TefsirExtendedColors(
            gradientStart = TefsirColors.BrandGradientStartLight,
            gradientEnd = TefsirColors.BrandGradientEndLight,
            brandPrimaryMuted = TefsirColors.BrandPrimaryMutedLight,
            surfaceCard = TefsirColors.SurfaceCardLight,
        )
    }

    androidx.compose.runtime.CompositionLocalProvider(LocalTefsirExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = TefsirTypography,
            content = content,
        )
    }
}
