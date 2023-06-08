package com.ton_blockchain.ton_wallet_challenge.presentation

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import com.orhanobut.hawk.Hawk
import com.ton_blockchain.ton_wallet_challenge.common.Constants.HAWK_IS_WALLET_CREATED
import com.ton_blockchain.ton_wallet_challenge.common.Constants.HAWK_PASSCODE
import com.ton_blockchain.ton_wallet_challenge.common.navigation.Navigation
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Ton_wallet_challengeTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalGetImage
@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ton_wallet_challengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
                    SetStartDestination(this)
                }
            }
        }
    }
}

@ExperimentalGetImage
@Composable
fun SetStartDestination(context: FragmentActivity) {
    if (Hawk.get(HAWK_IS_WALLET_CREATED, false)) {
        if (Hawk.get(HAWK_PASSCODE, "") != "") {
            Navigation(TonWalletScreens.PinScreen.route, context)
        } else {
            Navigation(TonWalletScreens.MainScreen.route, context)
        }
    } else {
        Navigation(TonWalletScreens.WalletScreen.route, context)
    }
}
