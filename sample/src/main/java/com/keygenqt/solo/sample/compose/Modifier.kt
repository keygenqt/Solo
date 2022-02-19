package com.keygenqt.solo.sample.compose

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer

/**
 * Collapse list item animation
 */
fun Modifier.graphicsCollapse(
    state: LazyListState
) = this.composed {
    var scrolledY by remember { mutableStateOf(0f) }
    var previousOffset by remember { mutableStateOf(0) }
    graphicsLayer {
        scrolledY += state.firstVisibleItemScrollOffset - previousOffset
        translationY = scrolledY * 0.5f
        previousOffset = state.firstVisibleItemScrollOffset
    }
}