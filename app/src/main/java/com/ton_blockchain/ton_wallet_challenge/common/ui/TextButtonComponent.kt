package com.ton_blockchain.ton_wallet_challenge.common.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80

@Composable
fun TextButtonComponent(text: String, onButtonClickEvent: () -> Unit){
    TextButton(
        onClick = onButtonClickEvent,
        Modifier.padding(top = 16.dp, bottom = 32.dp)
    ) {
        Text(
           text = text,
            color = Blue80,
            fontSize = 16.sp,
            maxLines = 1
        )
    }
}