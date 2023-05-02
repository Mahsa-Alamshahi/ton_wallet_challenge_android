package com.ton_blockchain.ton_wallet_challenge.common.navigation

sealed class TonWalletScreens(val route: String) {
    object WalletScreen : TonWalletScreens("wallet_screen")
    object MainScreen : TonWalletScreens("main_screen")
    object RecoveryPhraseScreen : TonWalletScreens("recovery_phrase_screen")
    object TestPhraseScreen : TonWalletScreens("test_phrase_screen")
    object WalletCreatedSuccessfullyScreen : TonWalletScreens("wallet_created_screen")
}

