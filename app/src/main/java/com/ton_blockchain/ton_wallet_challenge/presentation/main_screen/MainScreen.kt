package com.ton_blockchain.ton_wallet_challenge.presentation.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.BalanceView
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.TransactionListItem

@Composable
fun MainScreen(navController: NavHostController) {

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        Column(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Black),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BalanceView()
        }

        Column(
            Modifier
                .weight(1.3f)
                .fillMaxWidth()
                .background(Color.White),
//            verticalArrangement = Arrangement.Start,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(2.dp)
            ) {
                item {
                    TransactionListItem()
                }
            }
        }
    }
}