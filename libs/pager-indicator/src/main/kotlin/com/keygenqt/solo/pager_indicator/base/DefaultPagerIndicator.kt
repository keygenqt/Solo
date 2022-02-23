package com.keygenqt.solo.pager_indicator.base

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlin.math.roundToInt

@ExperimentalPagerApi
@Composable
internal fun DefaultPagerIndicator(
    pagerState: PagerState,
    size: IntSize,
    maxCount: Int,
    activeColor: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    inactiveColor: Color = activeColor.copy(ContentAlpha.disabled),
    onClick: ((Int) -> Unit)? = null,
) {
    if (maxCount != 0) {

        var indicatorWidth: Dp
        var spacing: Dp
        var indicatorHeight: Dp

        val indicatorShape: Shape = RoundedCornerShape(3.dp)

        val step = pagerState.pageCount.toDouble() / (maxCount.toDouble() - (maxCount.toDouble() / pagerState.pageCount.toDouble()))

        Log.e("TAG ->", (step).toString())

        with(LocalDensity.current) {
            indicatorHeight = size.height.toDp()
            indicatorWidth = indicatorHeight * 24 / 3
            spacing = indicatorHeight * 8 / 3
        }

        val indicatorWidthPx = LocalDensity.current.run { indicatorWidth.roundToPx() }
        val spacingPx = LocalDensity.current.run { spacing.roundToPx() }

        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val indicatorModifier = Modifier
                .size(width = indicatorWidth, height = indicatorHeight)
                .background(color = inactiveColor, shape = indicatorShape)

            repeat(maxCount) { page ->
                if (onClick != null) {
                    Box(indicatorModifier.clickable {

                        Log.e("TAG", (page * step).toString())
                        Log.e("TAG", ((page * step).toInt()).toString())

                        onClick.invoke((page * step).toInt())
                    })
                } else {
                    Box(indicatorModifier)
                }
            }
        }

        val currentItem: Int = if (step != 0.0) {
            (pagerState.currentPage.toDouble() / step).roundToInt()
        } else {
            0
        }

        Box(
            Modifier
                .offset {
                    IntOffset(
                        x = ((spacingPx + indicatorWidthPx) * currentItem),
                        y = 0
                    )
                }
                .size(width = indicatorWidth, height = indicatorHeight)
                .background(
                    color = activeColor,
                    shape = indicatorShape,
                )
        )
    }
}