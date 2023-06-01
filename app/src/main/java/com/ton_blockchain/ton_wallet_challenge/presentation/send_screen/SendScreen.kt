package com.ton_blockchain.ton_wallet_challenge.presentation.send_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dokar.sheets.BottomSheet
import com.dokar.sheets.BottomSheetState
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.Constants.QR_READER_RESULT_KEY
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.ButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.Balance
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.MainScreenViewModel
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun SendScreen(
    sheetState: BottomSheetState,
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel()
) {


    var walletAddress by rememberSaveable {
        mutableStateOf("")
    }

    var amount by rememberSaveable {
        mutableStateOf("")
    }

    var comment by rememberSaveable {
        mutableStateOf("")
    }


    val state: MutableState<List<Balance>> = remember { mutableStateOf(emptyList()) }


    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            state.value = viewModel.getBalance()
        }
    }

    val qrScannerResult =
        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<String>(
                QR_READER_RESULT_KEY
            )?.observeAsState()


    if (sheetState.visible) {
        BottomSheet(state = sheetState) {

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {


                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    AnimationLoader(
                        R.raw.wallet_money, 88.dp, 88.dp,
                    )
                }

                TextComponent(
                    text = stringResource(R.string.send_toncoins),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                )

                TextField(
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start)
                        .fillMaxWidth(1f)
                        .padding(start = 2.dp, end = 2.dp, top = 8.dp, bottom = 4.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White, focusedIndicatorColor = Color.Blue
                    ),
                    value = walletAddress,
                    onValueChange = { newText ->
                        walletAddress = newText
                        qrScannerResult?.value?.let { qrResult ->
                            if (walletAddress != "") {
                                walletAddress = qrResult
                            } else {
                                walletAddress = newText
                            }
                        } ?: run {
                            walletAddress = newText
                        }
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            navController.navigate(TonWalletScreens.QrCodeScannerScreen.route)
                        }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_qr_code_scanner_24),
                                contentDescription = "",
                                tint = Color.Black
                            )
                        }
                    },
                    label = {
                        Text(
                            text = "Reciptient wallet address",
                            color = Blue80,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Enter wallet address", color = Color.DarkGray
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = {}),
                )


                TextField(modifier = Modifier
                    .wrapContentWidth(Alignment.Start)
                    .fillMaxWidth(1f)
                    .padding(start = 2.dp, end = 2.dp, top = 8.dp, bottom = 4.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White, focusedIndicatorColor = Color.Blue
                    ),
                    value = amount,
                    onValueChange = { newText ->
                        amount = newText
                    },
                    trailingIcon = {
                        AnimationLoader(
                            R.raw.wallet_gem, 36.dp, 36.dp,
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.amount),
                            color = Blue80,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    placeholder = { Text(text = "0.0", color = Color.DarkGray) })

                if (state.value.isNotEmpty()) {
                    TextComponent(
                        stringResource(R.string.balance) + state.value[0].available,
                        fontWeight = FontWeight.SemiBold,
                        textColor = Blue80,
                        modifier = Modifier.padding(16.dp)
                    )
                }


                TextField(modifier = Modifier
                    .wrapContentWidth(Alignment.Start)
                    .fillMaxWidth(1f)
                    .padding(start = 2.dp, end = 2.dp, top = 8.dp, bottom = 4.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White, focusedIndicatorColor = Color.Blue
                    ),
                    value = comment,
                    onValueChange = { newText ->
                        comment = newText
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.comment_optional), color = Color.DarkGray
                        )
                    })

                ButtonComponent(text = stringResource(R.string.send_toncoins)) {
                    navController.navigate(TonWalletScreens.SendResultScreen.route + "/${walletAddress}/${amount}/${comment}")
                }
            }
        }
    }
}