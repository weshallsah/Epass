package com.example.epass.View.Auth

import InputBox
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.epass.Model.AuthModel
import com.example.epass.R


@Composable
fun Signup(context: Context, Navcontroller: NavHostController) {
    var credentials by remember {
        mutableStateOf(AuthModel())
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        content = {
            Column {
                Box(
                    modifier = Modifier.padding(25.dp)
                )
                Text(
                    text = "Welcome to Epass",
                    modifier = Modifier.padding(
                        horizontal = 15.dp
                    ),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier.padding(
                        horizontal = 15.dp
                    ),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = "Create a Account to Buy Ticket's",
                )
                Box(modifier = Modifier.padding(10.dp))
                OutlinedButton(
                    onClick = { },
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 40.dp,
                            vertical = 15.dp
                        )
                        .height(60.dp),
                    colors = ButtonColors(
                        containerColor = Color.Unspecified,
                        contentColor = Color.Unspecified,
                        disabledContainerColor = Color.Unspecified,
                        disabledContentColor = Color.Unspecified
                    ),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.social),
                        contentDescription = "google icon"
                    )
                }
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth(),
                    Alignment.Center,
                    content = {
                        Text(
                            text = "OR",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
                InputBox(
                    input = credentials.name,
                    onChange = { credentials = credentials.copy(name = it) },
                    inputname = "name"
                )
                InputBox(
                    input = credentials.username,
                    onChange = { credentials = credentials.copy(username = it) },
                    inputname = "username"
                )
                InputBox(
                    input = credentials.email,
                    onChange = { credentials = credentials.copy(email = it) },
                    inputname = "email"
                )
                InputBox(
                    input = credentials.phone,
                    onChange = { credentials = credentials.copy(phone = it) },
                    inputname = "phone"
                )
                InputBox(
                    input = credentials.password,
                    onChange = { credentials = credentials.copy(password = it) },
                    inputname = "password"
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    Alignment.Center,
                    content = {
                        OutlinedButton(
                            onClick = {
                                Navcontroller.navigate("Home")
                                Toast.makeText(context, "Login Clicked", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .height(60.dp),
                            colors = ButtonColors(
                                containerColor = Color.Unspecified,
                                contentColor = Color.Unspecified,
                                disabledContainerColor = Color.Unspecified,
                                disabledContentColor = Color.Unspecified
                            ),
                            border = BorderStroke(1.dp, Color.Black)
                        ) {
                            Text(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                text = "Signup"
                            )
                        }
                    }
                )
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    contentAlignment = Alignment.BottomCenter,
                    content = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp)
                                .border(2.dp, color = Color.LightGray)
                                .background(
                                    color = Color.LightGray
                                )
                                .padding(
                                    horizontal = 10.dp,
                                    vertical = 5.dp
                                ),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Already have an account!  ",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                modifier = Modifier.clickable {
                                    Navcontroller.navigate("Login")
                                    Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
                                },
                                text = "Login",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Blue.copy(alpha = 0.65f)
                            )
                        }
                    }
                )
            }
        }
    )
}



