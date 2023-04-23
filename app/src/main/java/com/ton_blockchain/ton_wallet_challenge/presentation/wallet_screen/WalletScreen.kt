package com.ton_blockchain.ton_wallet_challenge.presentation.wallet_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader


@Composable
fun WalletScreen(navController: NavController) {

    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(paddingValues = PaddingValues(4.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {




        Column(
            Modifier.weight(2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AnimationLoader(resId = (R.raw.wallet_crystal), width = 94.dp ,
                height = 94.dp)

            Text(
                text = "TON Wallet",
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(0.dp),
            )

            Text(
                text = "TON wallet allows you to make fast and secure blockchain-based payments without intermediaries.",
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                style = LocalTextStyle.current.copy(lineHeight = 18.sp),
                fontSize = 14.sp, modifier = Modifier.padding(top = 12.dp, start= 4.dp, end = 4.dp)
            )
        }

        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                },
                Modifier.padding(top = 2.dp, start = 32.dp, end = 32.dp).fillMaxWidth(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue80,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Create My Wallet",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
            TextButton(
                onClick = {
                },
                Modifier.padding(top = 16.dp, bottom = 32.dp)
            ) {
                Text(
                    "Import Existing Wallet",
                    color = Blue80,
                    fontSize = 16.sp,
                    maxLines = 1
                )
            }


        }
    }
}
