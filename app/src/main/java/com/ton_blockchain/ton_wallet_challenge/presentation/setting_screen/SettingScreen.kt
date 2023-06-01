package com.ton_blockchain.ton_wallet_challenge.presentation.setting_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.simonsickle.compose.barcodes.Barcode
import com.simonsickle.compose.barcodes.BarcodeType
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun SettingScreen(navController: NavController, viewModel: SettingViewModel = hiltViewModel()) {


    var value by remember {
        mutableStateOf("")
    }


    Scaffold(topBar = {
        TopBarComponent {
            navController.navigateUp()
        }
    }) { paddingValues ->


        val state: MutableState<List<WalletEntity>> =
            remember { mutableStateOf(emptyList<WalletEntity>()) }


        LaunchedEffect(Unit) {
            withContext(Dispatchers.IO) {
                state.value = viewModel.getWallets()
            }
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {


            Column(
                Modifier
                    .weight(1f)
                    .background(Color.White)
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .border(
                            1.dp, Blue80, shape = RoundedCornerShape(6.dp)
                        )
                        .padding(4.dp), horizontalArrangement = Arrangement.Center
                ) {

                    if (state.value.isNotEmpty()) {

                        TextField(modifier = Modifier
                            .wrapContentWidth(Alignment.Start)

                            .fillMaxWidth(1f)
                            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
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
                                    text = "Wallet Address: \n ${state.value[0].address}",
                                    color = Blue80,
                                    fontWeight = FontWeight.SemiBold
                                )
                            })
                    }
                }

                OutlinedButton(
                    onClick = {
                              navController.navigate(TonWalletScreens.PasscodeScreen.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color.Blue),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = Blue80
                    )
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.width(width = 8.dp))
                        Text(text = "Set Passcode", fontSize = 14.sp)
                    }
                }
            }

            Column(
                Modifier.weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (state.value.isNotEmpty()) {

                    if (BarcodeType.QR_CODE.isValueValid(state.value[0].address.toString())) {
                        Barcode(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .width(256.dp)
                                .height(256.dp),
                            resolutionFactor = 10,
                            type = BarcodeType.QR_CODE,
                            value = state.value[0].address.toString()
                        )
                    }


                if (!BarcodeType.CODE_128.isValueValid(state.value[0].address.toString())) {
                    Text("This is not valid.")
                }
                }
            }

        }
    }
}

