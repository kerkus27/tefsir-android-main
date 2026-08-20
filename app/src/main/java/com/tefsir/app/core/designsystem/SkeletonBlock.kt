package com.tefsir.app.core.designsystem

import android.animation.ValueAnimator
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * Pulsing placeholder shown in place of content that's still loading, instead
 * of a bare spinner or an empty screen — the Compose counterpart of iOS's
 * SkeletonBlock. Compose several into a shape that echoes the real content's
 * layout so there's no visual jump once it arrives.
 */
@Composable
fun SkeletonBlock(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(8.dp),
) {
    // Mirrors iOS's @Environment(\.accessibilityReduceMotion) check: skip the
    // pulse when the system's "remove animations" accessibility setting is on.
    val animationsEnabled = remember { ValueAnimator.areAnimatorsEnabled() }
    val alpha = if (animationsEnabled) {
        val transition = rememberInfiniteTransition(label = "skeleton")
        transition.animateFloat(
            initialValue = 0.12f,
            targetValue = 0.06f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 900),
                repeatMode = RepeatMode.Reverse,
            ),
            label = "skeletonAlpha",
        ).value
    } else {
        0.12f
    }

    androidx.compose.foundation.layout.Box(
        modifier = modifier.background(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = alpha),
            shape = shape,
        ),
    )
}
