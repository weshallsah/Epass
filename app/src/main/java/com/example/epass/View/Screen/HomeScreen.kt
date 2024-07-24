package com.example.epass.View.Screen

import InputBox
import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CompareArrows
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.epass.Model.HomeModel
import com.example.epass.View.component.Button
import com.example.epass.View.component.HeroSlide
import com.example.epass.View.component.TransportMode


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(context: Context, navController: NavController) {
    var homeModel by remember {
        mutableStateOf(HomeModel())
    };
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                scrollBehavior = null,
//                modifier = Modifier
//                    .height(65.dp),
                title = {
                    Text(
                        text = "Epass",
                        fontSize = 28.sp,
                    )
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Explore is clicked", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Explore,
                            contentDescription = "Explore",
                        )
                    }
                    IconButton(onClick = {
                        navController.navigate("profile")
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Person,
                            contentDescription = "profile",
                        )
                    }
                }
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 65.dp)
//                    .background(Color.LightGray),
            ) {
                item {
                    HeroSlide(
                        context = context,
                        homeModel = homeModel,
                        {
                            homeModel = homeModel.copy(heropage = it)
                        }
                    )
                    Box(
                        modifier = Modifier
                            .height(80.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center,
                        content = {
                            Button(
                                onclicked = {
                                    Toast.makeText(
                                        context,
                                        homeModel.heropage.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                                width = 140,
                                height = 50,
                                name = "Check",
                            )
                        }
                    )
                    TransportMode(homeModel = homeModel, {
                        homeModel = homeModel.copy(selectmode = it)
                    })
                    InputBox(input = homeModel.From, onChange = {
                        homeModel = homeModel.copy(From = it.toString())
                    }, inputname = "From")
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center,
                        content = {
                            Icon(
                                modifier = Modifier.rotate(90f),
                                imageVector = Icons.Rounded.CompareArrows,
                                contentDescription = null,
                            )
                        }
                    )
                    InputBox(input = homeModel.To, onChange = {
                        homeModel = homeModel.copy(To = it.toString())
                    }, inputname = "To")
                }
            }
        }
    )
}


