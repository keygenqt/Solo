package com.keygenqt.solo.sample.features.ui.screens.loaders

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.keygenqt.routing.NavigationDispatcher
import com.keygenqt.solo.sample.features.ui.actions.LoadersActions

/**
 * Body for [LoadersScreen]
 */
@Composable
fun LoadersBody(
    navDispatcher: NavigationDispatcher? = null,
    onActions: (LoadersActions) -> Unit = {},
) {
    Text(
        modifier = Modifier,
        text = "LoadersBody"
    )
}