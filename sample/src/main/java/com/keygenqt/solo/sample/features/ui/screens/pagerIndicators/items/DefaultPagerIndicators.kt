package com.keygenqt.solo.sample.features.ui.screens.pagerIndicators.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.keygenqt.solo.sample.compose.texts.TextH3
import com.keygenqt.solo.sample.compose.texts.TextH5

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DefaultPagerIndicators() {

    val state = rememberPagerState()
    val count = 4

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
    ) {
        TextH5(text = "Default")
    }

    Spacer(modifier = Modifier.size(4.dp))

    HorizontalPager(
        state = state,
        count = count
    ) { page ->
        when (page) {
            0 -> TextH3(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red),
                text = "0"
            )
            1 -> TextH3(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray),
                text = "1"
            )
            2 -> TextH3(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                text = "2"
            )
            3 -> TextH3(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),
                text = "3"
            )
        }
    }

    Spacer(modifier = Modifier.size(8.dp))

    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        HorizontalPagerIndicator(
            modifier = Modifier.align(Alignment.Center),
            indicatorWidth = 4.dp,
            indicatorHeight = 4.dp,
            spacing = 4.dp,
            pagerState = state,
        )
    }
}