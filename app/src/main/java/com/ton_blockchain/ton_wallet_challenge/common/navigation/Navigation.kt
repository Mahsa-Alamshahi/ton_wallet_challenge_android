package com.ton_blockchain.ton_wallet_challenge.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TonWalletScreens.MainScreen.route) {
//        composable(route = TonWalletScreens.WalletScreen.route) {
//            WalletScreen(navController = navController)
//        }
        composable(route = TonWalletScreens.MainScreen.route) {
            MainScreen(navController = navController)
        }
    }
}