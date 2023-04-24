package com.ton_blockchain.ton_wallet_challenge.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.MainScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.RecoveryPhraseScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.test_phrase_screen.TestPhraseScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.wallet_screen.WalletScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TonWalletScreens.WalletScreen.route) {
        composable(route = TonWalletScreens.WalletScreen.route) {
            WalletScreen(navController = navController)
        }
        composable(
            route = TonWalletScreens.RecoveryPhraseScreen.route
        ) { entry ->
            RecoveryPhraseScreen(navController)
        }
        composable(
            route = TonWalletScreens.TestPhraseScreen.route
        ) { entry ->
            TestPhraseScreen(navController)
        }
        composable(
            route = TonWalletScreens.MainScreen.route
        ) { entry ->
            MainScreen(navController)
        }
    }
}