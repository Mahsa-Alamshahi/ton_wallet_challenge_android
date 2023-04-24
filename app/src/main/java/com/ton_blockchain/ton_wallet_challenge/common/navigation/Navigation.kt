package com.ton_blockchain.ton_wallet_challenge.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.RecoveryPhraseScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TonWalletScreens.RecoveryPhraseScreen.route) {
//        composable(route = TonWalletScreens.WalletScreen.route) {
//            WalletScreen(navController = navController)
//        }
        composable(route = TonWalletScreens.RecoveryPhraseScreen.route) {
            RecoveryPhraseScreen(navController = navController)
        }
    }
}