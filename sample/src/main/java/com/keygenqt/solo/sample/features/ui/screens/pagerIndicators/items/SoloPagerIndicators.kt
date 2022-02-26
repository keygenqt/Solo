package com.keygenqt.solo.sample.features.ui.screens.pagerIndicators.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.keygenqt.solo.pager_indicator.overload.SoloDefaultPagerIndicator
import com.keygenqt.solo.sample.compose.texts.TextH3
import com.keygenqt.solo.sample.compose.texts.TextH5
import kotlinx.coroutines.launch
import timber.log.Timber

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SoloPagerIndicators() {

    val items = (0..5).toList()
    val scope = rememberCoroutineScope()
    val state = rememberPagerState()
    val count = items.size

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
    ) {
        TextH5(text = "1")
    }

    Spacer(modifier = Modifier.size(4.dp))

    HorizontalPager(
        state = state,
        count = count
    ) { page ->
        items.forEach { index ->
            if (index == page) {
                TextH3(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            listOf(
                                Color.Red,
                                Color.Gray,
                                Color.Blue,
                                Color.Cyan,
                                Color.LightGray,
                                Color.Magenta,
                                Color.Yellow
                            ).random()
                        ),
                    text = "${index + 1}"
                )
            }
        }
    }

    Spacer(modifier = Modifier.size(8.dp))

    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        SoloDefaultPagerIndicator(
            maxCount = 6,
            modifier = Modifier
                .align(Alignment.Center)
                .height(3.dp),
            pagerState = state,
            onClick = {
                scope.launch {
                    state.animateScrollToPage(it)
                }
            }
        )
    }
}