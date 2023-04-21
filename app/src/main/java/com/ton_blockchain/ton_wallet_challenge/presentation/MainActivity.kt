package com.ton_blockchain.ton_wallet_challenge.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ton_blockchain.ton_wallet_challenge.common.theme.Ton_wallet_challengeTheme
import com.ton_blockchain.ton_wallet_challenge.presentation.wallet_screen.WalletScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ton_wallet_challengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   WalletScreen()
                }
            }
        }
    }
}
