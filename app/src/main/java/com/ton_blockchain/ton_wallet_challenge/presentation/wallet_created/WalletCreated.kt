package com.ton_blockchain.ton_wallet_challenge.presentation.wallet_created

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.orhanobut.hawk.Hawk
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.Constants
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.ButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun WalletCreatedScreen(
    navController: NavController,
    viewModel: WalletCreatedViewModel = hiltViewModel()
) {


    val state: MutableState<List<WalletEntity>> =
        remember { mutableStateOf(emptyList<WalletEntity>()) }


    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            state.value = viewModel.getWallets()
        }
    }


    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(paddingValues = PaddingValues(4.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {


        Column(
            Modifier.weight(2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AnimationLoader(
                resId = (R.raw.wallet_congrats)
            )

            TextComponent(
                text = stringResource(R.string.congratulations),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            TextComponent(
                text = stringResource(R.string.your_ton_wallet_has_just_been_created_only_you_control_it_to_be_able_to_always_have_access_to_it_please_write_down_secret_words_and_set_up_a_secure_passcode),
                modifier = Modifier.padding(top = 12.dp, start = 4.dp, end = 4.dp)
            )

            if (state.value.isNotEmpty()) {

                Hawk.put(Constants.HAWK_IS_WALLET_CREATED, true)

                Row(
                    modifier = Modifier
                        .border(1.dp, Blue80,
                            shape = RoundedCornerShape(6.dp)
                        ),
                    horizontalArrangement = Arrangement.Center
                ) {

                    TextComponent(
                        text = "Wallet Address: \n \n ${state.value[0].address}",
                        textColor = Blue80,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 12.dp, start = 6.dp, end = 6.dp, bottom = 12.dp)
                    )
                }
            }
        }

        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ButtonComponent(text = stringResource(R.string.proceed)) {
                navController.navigate(TonWalletScreens.MainScreen.route)
            }

            TextButtonComponent(text = stringResource(R.string.set_passcode)) {
                navController.navigate(TonWalletScreens.PasscodeScreen.route)
            }
        }
    }
}

