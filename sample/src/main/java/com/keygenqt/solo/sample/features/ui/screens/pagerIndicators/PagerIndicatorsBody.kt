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
package com.keygenqt.solo.sample.features.ui.screens.pagerIndicators

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.keygenqt.routing.NavigationDispatcher
import com.keygenqt.solo.sample.R
import com.keygenqt.solo.sample.compose.base.AppScaffold
import com.keygenqt.solo.sample.features.ui.actions.PagerIndicatorsActions
import com.keygenqt.solo.sample.features.ui.screens.pagerIndicators.items.DefaultManyPagerIndicators
import com.keygenqt.solo.sample.features.ui.screens.pagerIndicators.items.DefaultPagerIndicators
import com.keygenqt.solo.sample.features.ui.screens.pagerIndicators.items.SoloPagerIndicators

/**
 * Body for [PagerIndicatorsScreen]
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerIndicatorsBody(
    navDispatcher: NavigationDispatcher? = null,
    onActions: (PagerIndicatorsActions) -> Unit = {},
) {
    val scrollState = rememberScrollState()

    AppScaffold(
        navigationDispatcher = navDispatcher,
        topBarTitle = stringResource(id = R.string.pager_indicators_title)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            DefaultPagerIndicators()
            DefaultManyPagerIndicators()
            SoloPagerIndicators()
        }
    }
}
