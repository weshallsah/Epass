package com.example.epass.View.Auth

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.epass.Model.AuthModel
import com.example.epass.R

@Composable
fun Login(context: Context, Navcontroller: NavController) {

    var credentials by remember {
        mutableStateOf(AuthModel())
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        content = {
            Column(
                Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Box(
                        modifier = Modifier.padding(20.dp)
                    )
                    Text(
                        modifier = Modifier.padding(
                            horizontal = 15.dp
                        ),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Welcome to Epass",
                    )
                    Text(
                        modifier = Modifier.padding(
                            horizontal = 15.dp
                        ),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        text = "Login to Buy your Ticket's",
                    )
                    Box(modifier = Modifier.height(20.dp))
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
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.social),
                                contentDescription = "google icon"
                            )
                        }
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
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(15.dp)
                            .fillMaxWidth(),
                        label = { Text(text = "username") },
                        value = credentials.username,
                        onValueChange = {
                            credentials = credentials.copy(username = it)
                        },
                        textStyle = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Default
                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .fillMaxWidth(),
                        label = { Text(text = "password") },
                        value = credentials.password,
                        trailingIcon = {
                            Icons.Filled.VisibilityOff
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        onValueChange = {
                            credentials = credentials.copy(password = it)
                        },
                        textStyle = TextStyle(
                            fontSize = 18.sp
                        )
                    )
                    Box(
                        modifier = Modifier
                            .padding(
                                horizontal = 35.dp,
                                vertical = 10.dp
                            )
                            .fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd,
                        content = {
                            Row {
                                Text(
                                    text = "need help ? ",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    modifier = Modifier.clickable {
                                        Navcontroller.navigate("signup")
                                    },
                                    text = "forget password",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Blue
                                )
                            }
                        }
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
                                    text = "Login"
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
                                    text = "Don't have an account?  ",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    modifier = Modifier.clickable {
                                        Navcontroller.navigate("signup")
                                    },
                                    text = "Signup",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Blue
                                )
                            }
                        }
                    )
                }
            )
        }
    )
}
