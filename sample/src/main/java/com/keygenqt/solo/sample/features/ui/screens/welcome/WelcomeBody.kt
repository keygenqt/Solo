package com.keygenqt.solo.sample.features.ui.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.keygenqt.routing.NavigationDispatcher
import com.keygenqt.solo.sample.compose.graphicsCollapse
import com.keygenqt.solo.sample.features.ui.actions.WelcomeActions
import com.keygenqt.solo.sample.utils.Components

/**
 * Body for [WelcomeScreen]
 */
@Composable
fun WelcomeBody(
    lazyListState: LazyListState = rememberLazyListState(),
    navDispatcher: NavigationDispatcher? = null,
    onActions: (WelcomeActions) -> Unit = {},
) {
    LazyColumn(
        modifier = Modifier,
        state = lazyListState
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsCollapse(lazyListState)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(Color.Red)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "WelcomeBody"
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
        (Components.values() + Components.values() + Components.values()).forEach { item ->
            item {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(horizontal = 16.dp),
                ) {
                    Card(
                        elevation = 3.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .clickable {
                                    onActions(WelcomeActions.ToPageFeature(item))
                                }
                                .padding(
                                    vertical = 30.dp,
                                    horizontal = 16.dp
                                )
                        ) {
                            Text(
                                text = stringResource(id = item.title)
                            )
                        }
                    }
                }
            }
        }
    }
}