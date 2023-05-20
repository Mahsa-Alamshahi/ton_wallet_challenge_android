package com.ton_blockchain.ton_wallet_challenge.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.orhanobut.hawk.Hawk
import com.ton_blockchain.ton_wallet_challenge.common.Constants.HAWK_IS_WALLET_CREATED
import com.ton_blockchain.ton_wallet_challenge.common.Constants.HAWK_PASSCODE
import com.ton_blockchain.ton_wallet_challenge.common.navigation.Navigation
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Ton_wallet_challengeTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalGetImage
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ton_wallet_challengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetStartDestination()
                }
            }
        }
    }
}

@ExperimentalGetImage
@Composable
fun SetStartDestination() {
    if (Hawk.get(HAWK_PASSCODE, "") != null) {
        Navigation(TonWalletScreens.PinScreen.route)
    } else {
        if (Hawk.get(HAWK_IS_WALLET_CREATED, false)) {
            Navigation(TonWalletScreens.MainScreen.route)
        } else {
            Navigation(TonWalletScreens.WalletScreen.route)
        }
    }

}
