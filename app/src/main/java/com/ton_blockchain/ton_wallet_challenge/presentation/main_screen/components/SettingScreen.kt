package com.ton_blockchain.ton_wallet_challenge.presentation.setting_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.simonsickle.compose.barcodes.Barcode
import com.simonsickle.compose.barcodes.BarcodeType
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
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {


            Column(
                Modifier.weight(.5f).background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(modifier = Modifier
                    .wrapContentWidth(Alignment.Start)
                    .fillMaxWidth(1f)
                    .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 4.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White, focusedIndicatorColor = Color.Blue
                    ),
                    value = value,
                    enabled = false,
                    onValueChange = { newText ->
                        value = newText
                    },
                    label = {
                        Text(
                            text = "Wallet Address",
                            color = Blue80,
                            fontWeight = FontWeight.SemiBold
                        )
                    })
            }

            Column(
                Modifier.weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val URL = "bitcoin:3J98t1WpEZ73CNmQviecrnyiWrnqRhWNLy"

                if (BarcodeType.QR_CODE.isValueValid(URL)) {
                    Barcode(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(256.dp)
                            .height(256.dp),
                        resolutionFactor = 10,
                        type = BarcodeType.QR_CODE,
                        value = URL
                    )
                }

                if (!BarcodeType.CODE_128.isValueValid(URL)) {
                    Text("This is not valid.")
                }
            }

        }
    }
}