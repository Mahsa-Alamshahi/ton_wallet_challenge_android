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
import androidx.compose.material3.rememberSheetState
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.MainScreenViewModel
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.send_screen.SendScreen
import kotlinx.coroutines.launch

@Composable
fun BalanceView(navController: NavController, viewModel: MainScreenViewModel) {

    val sheetState = rememberSheetState()
    val scope = rememberCoroutineScope()


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

                Text(
                    text = viewModel.showBalance(),
                    textAlign = TextAlign.Center, color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 32.sp
                )
            }
        }


        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {

            OutlinedButton(
                onClick = { },
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
                    scope.launch {
                        sheetState.show()
                    }
////                            sheetState.animateTo(ModalBottomSheetValue.Expanded)
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

    SendScreen(sheetState = sheetState, scope = scope, navController)
}


