package com.example.epass.View.component

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.epass.Model.HomeModel
import kotlin.math.absoluteValue


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeroSlide(context: Context, homeModel: HomeModel, onclick: (Int) -> Unit) {
    var PagerState =
        rememberPagerState(initialPage = 1, pageCount = { homeModel.sliderState.size });
    HorizontalPager(
        state = PagerState,
        contentPadding = PaddingValues(horizontal = 55.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) { page ->
        onclick(PagerState.currentPage)
        Card(
            colors = CardDefaults.cardColors(Color.Transparent),
            modifier = Modifier
                .graphicsLayer {
                    val pageoffset = calculatecurrentoffset(
                        page = page,
                        pagerState = PagerState
                    ).absoluteValue
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageoffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageoffset.coerceIn(0f, 1f)
                    )
                },
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = homeModel.sliderState[page]),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    alpha = 0.6f,
                    colorFilter = ColorFilter.tint(
                        color = Color.LightGray,
                        blendMode = BlendMode.Darken
                    )
                )
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier
                        .height(200.dp),
//                                        .background(Color.LightGray.copy(alpha = 0.45f)),
                    content = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.DarkGray,
                                text = "Welcome to India",
                            )
                            Text(
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                overflow = TextOverflow.Ellipsis,
                                style = TextStyle(
                                    shadow = Shadow(color = Color.DarkGray)
                                ),
                                text = "Vist India and Explore the cluture with the",
                            )
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
fun calculatecurrentoffset(page: Int, pagerState: PagerState): Float {
    return (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
}