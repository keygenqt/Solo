package com.keygenqt.solo.pager_indicator.overload

import androidx.annotation.IntRange
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.keygenqt.solo.pager_indicator.StylesSoloPagerIndicator
import com.keygenqt.solo.pager_indicator.base.BasePagerIndicator

@ExperimentalPagerApi
@Composable
fun SoloDefaultPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    maxCount: Int = pagerState.pageCount,
    activeColor: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    inactiveColor: Color = activeColor.copy(ContentAlpha.disabled),
    onClick: ((Int) -> Unit)? = null,
) = BasePagerIndicator(
    pagerState = pagerState,
    modifier = modifier,
    maxCount = maxCount,
    activeColor = activeColor,
    inactiveColor = inactiveColor,
    onClick = onClick,
    style = StylesSoloPagerIndicator.StyleDefault
)