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
package com.keygenqt.solo.sample.features.navigation.graph.impl

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.keygenqt.solo.sample.base.AppNavActions
import com.keygenqt.solo.sample.features.navigation.route.NavRoute
import com.keygenqt.solo.sample.features.ui.screens.chips.ChipsScreen

/**
 * NavGraph for [ChipsScreen]
 */
fun NavGraphBuilder.chipsGraph(
    navActions: AppNavActions,
) {
    composable(
        route = NavRoute.chips.default.route
    ) {
        ChipsScreen(viewModel = hiltViewModel()) {
        }
    }
}
