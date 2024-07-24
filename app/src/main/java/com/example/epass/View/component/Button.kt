package com.example.epass.View.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Button(onclicked: () -> Unit, width: Int, height: Int, name: String) {
    androidx.compose.material3.Button(
        onClick = onclicked,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .height(height.dp)
            .width(width.dp),
    ) {
        Text(
            text = name,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

