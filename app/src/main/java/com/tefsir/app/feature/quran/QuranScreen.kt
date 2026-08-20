package com.tefsir.app.feature.quran

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/** Placeholder — real content (surah list, Arabic/Turkish reader, licenses screen) lands in feature/quran. */
@Composable
fun QuranScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Kur'an-ı Kerim", style = MaterialTheme.typography.headlineSmall)
    }
}
