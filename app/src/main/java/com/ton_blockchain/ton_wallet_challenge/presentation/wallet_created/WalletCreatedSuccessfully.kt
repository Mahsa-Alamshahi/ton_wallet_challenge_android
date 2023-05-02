package com.ton_blockchain.ton_wallet_challenge.presentation.wallet_created

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader


@Composable
fun WalletCreatedSuccessfullyScreen(navController: NavController){

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
                resId = (R.raw.wallet_congrats))

            TextComponent(
                text = stringResource(R.string.congratulations),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(0.dp)
            )
            TextComponent(
                text = stringResource(R.string.your_ton_wallet_has_just_been_created_only_you_control_it_to_be_able_to_always_have_access_to_it_please_write_down_secret_words_and_set_up_a_secure_passcode),
                modifier = Modifier.padding(top = 12.dp, start = 4.dp, end = 4.dp)
            )
        }

        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navController.navigate("recovery_phrase_screen")

                },
                Modifier
                    .padding(top = 2.dp, start = 32.dp, end = 32.dp)
                    .fillMaxWidth(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue80,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.proceed),
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
        }
    }

}