package com.ton_blockchain.ton_wallet_challenge.presentation.wallet_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WalletScreen() {

    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(paddingValues = PaddingValues(4.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Server",
                color = Color.Gray,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Text(
                "Import Existing Wallet",
                color = Color.Gray,
                fontSize = 12.sp,
                maxLines = 1
            )
        }

        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Toncoin Wallet",
                color = Color.DarkGray,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(10.dp),
            )

            Text(
                text = "The Toncoin wallet allows you to make fast and secure blockchain-based payments without intermediaries.",
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                fontSize = 12.sp, modifier = Modifier.padding(top = 16.dp)
            )
        }

        Column(
            Modifier.weight(2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                },
                Modifier.padding(top = 64.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Create My Wallet",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
        }
    }
}
