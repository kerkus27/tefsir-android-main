package com.tefsir.app.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Radar
import androidx.compose.ui.graphics.vector.ImageVector
import com.tefsir.app.R

/**
 * The five bottom-bar tabs, in the fixed order the iOS app uses (RootView.swift):
 * Ana Sayfa, Vakitler, Kur'an, Zikir, Diğer. Qibla and Mosque Finder are
 * intentionally not tabs — they open from Home's quick-access grid instead.
 */
enum class TefsirDestination(
    val route: String,
    @StringRes val labelRes: Int,
    val icon: ImageVector,
) {
    Home("home", R.string.tab_home, Icons.Filled.Home),
    PrayerTimes("prayer_times", R.string.tab_prayer_times, Icons.Filled.AccessTime),
    Quran("quran", R.string.tab_quran, Icons.Filled.MenuBook),
    Dhikr("dhikr", R.string.tab_dhikr, Icons.Filled.Radar),
    More("more", R.string.tab_more, Icons.Filled.MoreHoriz),
}
