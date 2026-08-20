package com.tefsir.app.core.designsystem

import androidx.compose.ui.graphics.Color

/**
 * Brand color tokens — light/dark pairs mirroring the iOS AppTheme.swift
 * palette values exactly, so both platforms read as the same product.
 */
object TefsirColors {
    val BrandPrimaryLight = Color(0xFF0F7A5C)
    val BrandPrimaryDark = Color(0xFF3DC292)

    val BrandGradientStartLight = Color(0xFF0B6B50)
    val BrandGradientStartDark = Color(0xFF0C4A38)
    val BrandGradientEndLight = Color(0xFF179A73)
    val BrandGradientEndDark = Color(0xFF166E54)

    val BrandPrimaryMutedLight = Color(0x1A0F7A5C)
    val BrandPrimaryMutedDark = Color(0x333DC292)

    val SurfaceCardLight = Color(0xFFF2F2F7)
    val SurfaceCardDark = Color(0xFF1C1C1E)
}
