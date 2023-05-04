package com.ton_blockchain.ton_wallet_challenge.common.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80

@Composable
fun ButtonComponent(text: String, onButtonClickEvent: () -> Unit) {
    Button(
        onClick = onButtonClickEvent,
        Modifier
            .padding(top = 32.dp, start = 32.dp, end = 32.dp, bottom = 32.dp)
            .fillMaxWidth(1f),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue80,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            maxLines = 1,
            modifier= Modifier.padding(6.dp)
        )
    }
}