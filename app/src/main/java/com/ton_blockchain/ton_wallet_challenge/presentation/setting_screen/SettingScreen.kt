package com.ton_blockchain.ton_wallet_challenge.presentation.setting_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80

@Composable
fun SettingScreen(navController: NavController) {

    var value by remember {
        mutableStateOf("")
    }

    Scaffold(topBar = {
        TopBarComponent {
            navController.navigateUp()
        }
    }) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxWidth().background(Color.White)
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            TextField(
                modifier = Modifier
                    .wrapContentWidth(Alignment.Start)
                    .fillMaxWidth(1f)
                    .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 4.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Blue
                ),
                value = value,
                enabled = false,
                onValueChange = { newText ->
                    value = newText
                },

                label = { Text(text = "Wallet Address", color = Blue80, fontWeight = FontWeight.SemiBold) })
        }
    }
}