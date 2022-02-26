package com.keygenqt.solo.pager_indicator.base

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlin.math.roundToInt

@ExperimentalPagerApi
@Composable
internal fun TwoPagerIndicator(
    pagerState: PagerState,
    height: Dp,
    maxCount: Int,
    activeColor: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    inactiveColor: Color = activeColor.copy(ContentAlpha.disabled),
    onClick: ((Int) -> Unit)? = null,
) {
    val shape: Shape = RoundedCornerShape(3.dp)
    val size = DpSize(height * 24 / 3, height)
    val spacing = size.height * 8 / 3

    fun remainder(size: Int, max: Int): Int {
        var count = 0
        var a = size
        while (true) {
            if (a % max == 0) {
                return count
            }
            a -= 1
            count++
        }
    }


    fun getActionIndex(size: Int, max: Int, page: Int): Int {
        return when {
            max == 1 || page == 0 -> 0
            page == max - 1 -> size - 1
            max == 3 && page == 1 -> (size / 2f).roundToInt()
            else -> {
                val remainder = remainder(size, max)
                (page * ((size - remainder) / max) + (remainder / 2)).let {
                    it + if (it > (size - remainder) / 2 && remainder % 2 != 0) 1 else 0
                }
            }
        }
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val indicatorModifier = Modifier
            .size(width = size.width, height = size.height)
            .background(color = inactiveColor, shape = shape)

        repeat(maxCount) { page ->
            if (onClick != null) {
                Box(indicatorModifier.clickable {
                    onClick.invoke(getActionIndex(
                        size = pagerState.pageCount,
                        max = maxCount,
                        page = page
                    ))
                })
            } else {
                Box(indicatorModifier)
            }
        }
    }
}