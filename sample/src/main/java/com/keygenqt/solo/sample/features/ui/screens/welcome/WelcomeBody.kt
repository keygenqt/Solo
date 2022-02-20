/*
 * Copyright 2022 Vitaliy Zarubin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.keygenqt.solo.sample.features.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.keygenqt.routing.NavigationDispatcher
import com.keygenqt.solo.sample.BuildConfig
import com.keygenqt.solo.sample.R
import com.keygenqt.solo.sample.compose.base.AppScaffold
import com.keygenqt.solo.sample.compose.extension.graphicsCollapse
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
    AppScaffold(
        background = MaterialTheme.colors.secondary,
        navigationDispatcher = navDispatcher,
        topBarTitle = stringResource(id = R.string.app_name),
        topBarSubtitle = "v${BuildConfig.VERSION_NAME}"
    ) {
        LazyColumn(
            modifier = Modifier,
            state = lazyListState
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                        .graphicsCollapse(lazyListState)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 30.dp, horizontal = 20.dp)
                                .align(Alignment.BottomStart),
                            contentScale = ContentScale.FillWidth,
                            painter = painterResource(R.drawable.welcome),
                            contentDescription = null,
                        )
                    }
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                            .background(MaterialTheme.colors.secondary)
                            .height(28.dp)
                            .fillMaxWidth()
                    ) {}
                }
            }
            Components.values().forEach { item ->
                item {
                    ItemFeature(item = item, onClick = {
                        onActions(WelcomeActions.ToPageFeature(it))
                    })
                }
            }
            item {
                Spacer(modifier = Modifier.size(12.dp))
            }
        }
    }
}

@Composable
private fun ItemFeature(
    item: Components,
    onClick: (Components) -> Unit
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.secondary)
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
                        onClick(item)
                    }
                    .background(MaterialTheme.colors.background)
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
