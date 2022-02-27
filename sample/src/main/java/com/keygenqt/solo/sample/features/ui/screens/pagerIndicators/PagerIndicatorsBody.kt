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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.keygenqt.routing.NavigationDispatcher
import com.keygenqt.solo.pager_indicator.base.remainder
import com.keygenqt.solo.sample.R
import com.keygenqt.solo.sample.compose.base.AppScaffold
import com.keygenqt.solo.sample.features.ui.actions.PagerIndicatorsActions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

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

    val scope = rememberCoroutineScope()

    SideEffect {
        scope.launch {
            // size
            (12..12).forEach { size ->
                // indicator
                (5..5).forEach { max ->
                    if (size > max) {
                        // page
                        (0 until max).forEach { page ->

                            val remainder = remainder(size, max)
                            val even = remainder % 2 == 0
                            val step = ((size - remainder) / max)
                            val points = if (even) remainder / 2 else (remainder - 1) / 2

//                            val index = if (page == (size - remainder - 1) / step) {
//                                size - 1
//                            } else {
//                                when {
//                                    page < points -> {
//                                        (page * step) + page
//                                    }
//                                    ((size - remainder) / step) - page <= points -> {
//                                        (page * step) + points + ((points + 1) - (((size - remainder) / step) - page))
//                                    }
//                                    else -> {
//                                        (page * step) + points
//                                    }
//                                }
//                            }

                            Timber.e((remainder).toString())
                            Timber.e((((size - remainder) / step) - page <= points).toString())

                            val index = when {
                                page < points -> {
                                    (page * step) + page
                                }
                                ((size - remainder) / step) - page <= points -> {
                                    (page * step) + points + ((points + 1) - (((size - remainder) / step) - page))
                                }
                                else -> {
                                    (page * step) + points
                                }
                            }

                            Timber.e("page -> $page, index -> $index")
                            Timber.e("size -> $size, max -> $max")
                            Timber.e("remainder -> $remainder")
                            Timber.e("step -> $step")
                            Timber.e("-------------------")

                            delay(10)
                        }
                    }
                }
            }
        }
    }

    AppScaffold(
        navigationDispatcher = navDispatcher,
        topBarTitle = stringResource(id = R.string.pager_indicators_title)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {

//            SoloPagerIndicators(
//                pager = 1,
//                size = 6
//            )
        }
    }
}
