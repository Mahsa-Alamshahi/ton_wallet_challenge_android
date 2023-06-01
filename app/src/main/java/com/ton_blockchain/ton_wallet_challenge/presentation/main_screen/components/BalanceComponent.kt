package com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dokar.sheets.rememberBottomSheetState
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.Balance
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.MainScreenViewModel
import com.ton_blockchain.ton_wallet_challenge.presentation.send_screen.SendScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun BalanceView(navController: NavController, viewModel: MainScreenViewModel= hiltViewModel()) {



    val scope = rememberCoroutineScope()
    val sheetState = rememberBottomSheetState()


    val state: MutableState<List<Balance>> =
        remember { mutableStateOf(emptyList()) }


    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            state.value = viewModel.getBalance()
        }
    }


    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = {
                navController.navigate(TonWalletScreens.SettingScreen.route)
            }) {
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
                text = stringResource(R.string.your_balance),
                textAlign = TextAlign.Center, color = Color.White
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AnimationLoader(
                    R.raw.wallet_crystal, 36.dp, 36.dp
                )

                if (state.value.isNotEmpty()) {

                Text(
                    text = state.value[0].available,
                    textAlign = TextAlign.Center, color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp
                )
                }
            }
        }


        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {

            OutlinedButton(
                onClick = {
                          navController.navigate(TonWalletScreens.ReceiveScreen.route)
                },
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
                onClick = {
               scope.launch { sheetState.expand() }
                },
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
    SendScreen(sheetState = sheetState, navController)

}


