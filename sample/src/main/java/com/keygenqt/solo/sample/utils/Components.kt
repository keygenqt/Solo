package com.keygenqt.solo.sample.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.keygenqt.solo.sample.R

enum class Components(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    val coming: Boolean
) {
    PAGER_INDICATORS(
        icon = R.drawable.ic_pager_indicator,
        title = R.string.components_pager_indicators,
        description = R.string.components_pager_indicators_desc,
        coming = true
    ),
    CHIPS(
        icon = R.drawable.ic_chips,
        title = R.string.components_chips,
        description = R.string.components_chips_desc,
        coming = true
    ),
    LOADERS(
        icon = R.drawable.ic_loader,
        title = R.string.components_loaders,
        description = R.string.components_loaders_desc,
        coming = true
    ),
}