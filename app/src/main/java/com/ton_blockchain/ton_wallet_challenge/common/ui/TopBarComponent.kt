package com.ton_blockchain.ton_wallet_challenge.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80

@Composable
fun TopBarComponent(onClickEvent: () -> Unit){

    Row(modifier = Modifier.fillMaxWidth().background(Color.White),
        verticalAlignment = Alignment.CenterVertically) {
        TextButton(
            onClick = onClickEvent,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(Icons.Default.ArrowBack,"",
                tint = Blue80,
                modifier = Modifier
                    .padding(4.dp)
            )
            Text(
                text = stringResource(id = R.string.back),
                fontSize = 16.sp,
                color = Blue80
            )
        }
    }
}