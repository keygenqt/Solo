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
package com.keygenqt.solo.sample.features.ui.screens.loaders

import androidx.compose.runtime.Composable
import com.keygenqt.solo.sample.base.LocalNavigationDispatcher
import com.keygenqt.solo.sample.features.ui.actions.LoadersActions
import com.keygenqt.solo.sample.features.ui.models.LoadersViewModel

/**
 * Base page fun for initialization
 *
 * @param viewModel page view model
 * @param onActions actions for page
 */
@Composable
fun LoadersScreen(
    viewModel: LoadersViewModel,
    onActions: (LoadersActions) -> Unit = {},
) {
    LoadersBody(
        onActions = onActions,
        navDispatcher = LocalNavigationDispatcher.current
    )
}
