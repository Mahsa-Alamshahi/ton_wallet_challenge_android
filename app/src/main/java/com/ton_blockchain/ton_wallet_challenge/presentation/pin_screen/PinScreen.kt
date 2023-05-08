package com.ton_blockchain.ton_wallet_challenge.presentation.pin_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader
import xyz.teamgravity.pin_lock_compose.PinLock

@Composable
fun PinScreen(navController: NavController){

        PinLock(
            title = { pinExists ->
                Column(
                    Modifier.padding(4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AnimationLoader(
                        resId = (R.raw.wallet_lock)
                    )

                    Text(text = if (pinExists) "Enter your pin" else "Create pin")
                }
            },
                color = Color.Blue.copy(alpha = 0.5F),
            onPinCorrect = {
                // pin is correct, navigate or hide pin lock
            },
            onPinIncorrect = {
                // pin is incorrect, show error
            },
            onPinCreated = {
                // pin created for the first time, navigate or hide pin lock
            }
        )

}