package com.ton_blockchain.ton_wallet_challenge.common.navigation

sealed class TonWalletScreens(val route: String) {
    object WalletScreen : TonWalletScreens("wallet_screen")
    object MainScreen : TonWalletScreens("main_screen")
}

