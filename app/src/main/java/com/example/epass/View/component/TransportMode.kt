package com.example.epass.View.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.epass.Model.HomeModel

@Composable
fun TransportMode(homeModel: HomeModel, ontap: (idx: Int) -> Unit) {
    LazyRow(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items(count = homeModel.Mode.size) { idx ->
            Box(
                modifier = Modifier
                    .border(
                        if (homeModel.selectmode == idx) {
                            1.dp
                        } else {
                            0.dp
                        },
                        if (homeModel.selectmode == idx) {
                            Color.DarkGray
                        } else {
                            Color.Transparent
                        },
                        shape = RoundedCornerShape(15.dp)
                    )
                    .background(
                        if (homeModel.selectmode == idx) {
                            Color.Cyan.copy(alpha = 0.35f)
                        } else {
                            Color.Transparent
                        },
                        shape = RoundedCornerShape(15.dp)
                    )
                    .height(70.dp)
                    .width(70.dp)
                    .clickable(
                        onClick = { ontap(idx) }
                    ),
                contentAlignment = Alignment.Center,
                content = {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,

                        ) {
                        Box(
                            content = {
                                Icon(
                                    painter = painterResource(homeModel.Mode[idx].second),
                                    contentDescription = null,
                                    modifier = Modifier.height(30.dp)
                                )
                            }
                        )
                        Text(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            text = homeModel.Mode[idx].first,
                        )
                    }
                })
        }

    }
}