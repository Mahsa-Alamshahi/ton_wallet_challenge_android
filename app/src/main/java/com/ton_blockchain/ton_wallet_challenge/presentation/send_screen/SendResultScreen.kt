package com.ton_blockchain.ton_wallet_challenge.presentation.send_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.simonsickle.compose.barcodes.Barcode
import com.simonsickle.compose.barcodes.BarcodeType
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader

@Composable
fun SendResultScreen(
    navController: NavController,
    walletAddress: String,
    amount: Float?,
    comment: String
) {


    val customCardElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,
        pressedElevation = 2.dp,
        focusedElevation = 4.dp
    )


    println("====== $walletAddress  $amount  $comment")
    Scaffold(topBar = {
        TopBarComponent {
            navController.navigateUp()
        }
    }) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues = paddingValues)) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
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


                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
//                    .border(width = 1.dp, color = Color.Gray)
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = customCardElevation
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        AnimationLoader(resId = R.raw.wallet_crystal, width = 64.dp, height = 64.dp)
                        TextComponent(text = "Your Order", fontWeight = FontWeight.Bold)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(vertical = 0.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextComponent(text = "Wallet Address:", textAlign = TextAlign.Start)
                            TextComponent(
                                text = walletAddress,
                                textAlign = TextAlign.End,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(vertical = 0.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextComponent(text = "Amount:", textAlign = TextAlign.Start)
                            TextComponent(
                                text = amount.toString(),
                                textAlign = TextAlign.End,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(vertical = 0.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextComponent(text = "Comment:", textAlign = TextAlign.Start)
                            TextComponent(
                                text = comment,
                                textAlign = TextAlign.End,
                                fontWeight = FontWeight.Bold
                            )
                        }

                    }
                }
            }
        }
    }
}
