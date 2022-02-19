package com.keygenqt.solo.sample.features.ui.screens.chips

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.keygenqt.routing.NavigationDispatcher
import com.keygenqt.solo.sample.features.ui.actions.ChipsActions

/**
 * Body for [ChipsScreen]
 */
@Composable
fun ChipsBody(
    navDispatcher: NavigationDispatcher? = null,
    onActions: (ChipsActions) -> Unit = {},
) {
    Text(
        modifier = Modifier,
        text = "ChipsBody"
    )
}