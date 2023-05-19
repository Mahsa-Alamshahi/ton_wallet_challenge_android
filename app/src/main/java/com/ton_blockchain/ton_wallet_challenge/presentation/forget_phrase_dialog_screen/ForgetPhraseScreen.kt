package com.ton_blockchain.ton_wallet_challenge.presentation.forget_phrase_dialog_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.ButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader


@Composable
fun ForgetPhraseScreen(
    navController: NavController
) {

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                AnimationLoader(
                    resId = (R.raw.wallet_toobad)
                )

                TextComponent(
                    text = stringResource(R.string.too_bad),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 12.dp)
                )
                TextComponent(
                    text = stringResource(R.string.forget_secret_words_content),
                    modifier = Modifier.padding(top = 12.dp, start = 4.dp, end = 4.dp)
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                ButtonComponent(text = stringResource(R.string.enter_24_secret_words)) {
                    navController.navigateUp()
                }


                TextButtonComponent(  text = stringResource(R.string.create_a_new_empty_wallet)) {
                    navController.navigate(TonWalletScreens.RecoveryPhraseScreen.route)
                }

            }
        }
    }
}

