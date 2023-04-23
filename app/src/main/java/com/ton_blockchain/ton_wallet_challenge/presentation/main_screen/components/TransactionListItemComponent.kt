package com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun TransactionListItem(){

    val customCardElevation = CardDefaults.cardElevation(
        defaultElevation = 8. dp,
        pressedElevation = 2. dp,
        focusedElevation = 4. dp
    )

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.White),
        elevation = customCardElevation
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
                .padding(12.dp)
        ) {
            Text(text = "date")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 2.dp),
                horizontalArrangement = Arrangement.Start
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .wrapContentHeight()
                        .padding(vertical = 0.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        modifier = Modifier.padding(end = 8.dp),
                        contentDescription = "", tint = Color.White
                    )
                    Text(
                        " 53.233333 from",
                    )
                }
                Text(
                    "22:52",
                )
            }
            Text(
                "wallet address",
            )
            Text(
                " 53.233333 from",
            )
        }
    }

}