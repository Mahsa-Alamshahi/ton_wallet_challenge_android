package com.ton_blockchain.ton_wallet_challenge.presentation.send_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.simonsickle.compose.barcodes.Barcode
import com.simonsickle.compose.barcodes.BarcodeType
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent

@Composable
fun SendResultScreen(
    navController: NavController,
    walletAddress: String,
    amount: Float?,
    comment: String
) {


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

            val qrValue = "ton://transfer/${walletAddress}?amount=${amount}&text=${comment}"

            if (walletAddress != "") {
                Barcode(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(256.dp)
                        .height(256.dp),
                    resolutionFactor = 10,
                    type = BarcodeType.QR_CODE,
                    value = qrValue
                )
            } else {
                Text("This is not valid.")
            }

        }
    }
}
