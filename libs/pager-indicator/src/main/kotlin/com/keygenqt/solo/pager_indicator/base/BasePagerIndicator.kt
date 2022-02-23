package com.keygenqt.solo.pager_indicator.base

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.keygenqt.solo.pager_indicator.StylesSoloPagerIndicator

@ExperimentalPagerApi
@Composable
internal fun BasePagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    maxCount: Int,
    activeColor: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    inactiveColor: Color = activeColor.copy(ContentAlpha.disabled),
    onClick: ((Int) -> Unit)?,
    style: StylesSoloPagerIndicator
) {
    var size by remember { mutableStateOf(IntSize.Zero) }

    Box(
        modifier = modifier.onSizeChanged {
            size = it
        },
        contentAlignment = Alignment.CenterStart
    ) {
        when (style) {
            StylesSoloPagerIndicator.StyleDefault -> DefaultPagerIndicator(
                pagerState = pagerState,
                size = size,
                maxCount = if (pagerState.pageCount > maxCount) maxCount else pagerState.pageCount,
                activeColor = activeColor,
                inactiveColor = inactiveColor,
                onClick = onClick,
            )
            StylesSoloPagerIndicator.StyleLines -> {
            }
            StylesSoloPagerIndicator.StyleCircle -> {}
            StylesSoloPagerIndicator.StyleMove -> {}
            StylesSoloPagerIndicator.StyleButton -> {}
            StylesSoloPagerIndicator.StylePager -> {}
        }
    }
}

