package com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80

@Composable
fun BalanceView() {



    Column {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.padding(8.dp)) {
                Image(painter = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
                    contentDescription = null,
                    modifier = Modifier.clickable { })
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TON btc",
                textAlign = TextAlign.Center, color = Color.White
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AnimationLoader(R.raw.wallet_crystal, 36.dp
                    ,36.dp)

                Text(
                    text = "5633.225222",
                    textAlign = TextAlign.Center, color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 32.sp
                )
            }
        }


        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)) {

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp, end = 4.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.Blue),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    containerColor = Blue80
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_south_west_24),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(width = 8.dp))
                    Text(text = stringResource(R.string.receive), fontSize = 14.sp)
                }
            }


            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp, end = 8.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.Blue),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    containerColor = Blue80
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_north_east_24),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(width = 8.dp))
                    Text(text = stringResource(R.string.send), fontSize = 14.sp)
                }
            }

        }

    }
}