package com.keygenqt.solo.sample.features.ui.screens.pagerIndicators

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.keygenqt.routing.NavigationDispatcher
import com.keygenqt.solo.sample.features.ui.actions.PagerIndicatorsActions

/**
 * Body for [PagerIndicatorsScreen]
 */
@Composable
fun PagerIndicatorsBody(
    navDispatcher: NavigationDispatcher? = null,
    onActions: (PagerIndicatorsActions) -> Unit = {},
) {
    Text(
        modifier = Modifier,
        text = "LoadersBody"
    )
}