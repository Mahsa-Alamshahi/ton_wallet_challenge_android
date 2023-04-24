package com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun PhraseList(){


    repeat(10) {
        Row(modifier = Modifier.padding(2.dp).fillMaxWidth()) {


        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .padding(2.dp)
                .weight(1f),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp,
                pressedElevation = 2.dp,
                focusedElevation = 4.dp
            )
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
//                    horizontalArrangement = Arrangement.Start,
//                    verticalAlignment = Alignment.CenterVertically
            ) {

            }
            Text(
                text = "index.toString()",
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "Word List",
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(2.dp)
            )
        }


            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .padding(2.dp)
                    .weight(1f),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 2.dp,
                    focusedElevation = 4.dp
                )
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
//                    horizontalArrangement = Arrangement.Start,
//                    verticalAlignment = Alignment.CenterVertically
                ) {

                }
                Text(
                    text = "index.toString()",
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(2.dp)
                )
                Text(
                    text = "Word List",
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(2.dp)
                )
            }

        }
//        Box(
//            modifier = Modifier
//                .size(64.dp)
//                .background(Blue)
//                .border(width = 1.dp, color = DarkGray),
//            contentAlignment = Alignment.Center,
//        ) {
//            Text(it.toString())
//        }
    }
}