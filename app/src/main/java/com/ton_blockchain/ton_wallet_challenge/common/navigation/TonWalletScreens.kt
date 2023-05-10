package com.ton_blockchain.ton_wallet_challenge.common.navigation

sealed class TonWalletScreens(val route: String) {
    object WalletScreen : TonWalletScreens("wallet_screen")
    object MainScreen : TonWalletScreens("main_screen")
    object RecoveryPhraseScreen : TonWalletScreens("recovery_phrase_screen")
    object TestPhraseScreen : TonWalletScreens("test_phrase_screen")
    object WalletCreatedSuccessfullyScreen : TonWalletScreens("wallet_created_screen")
    object ImportExistingWalletScreen : TonWalletScreens("import_existing_wallet_screen")
    object ForgetPhraseScreen : TonWalletScreens("forget_phrase_screen")
    object PasscodeScreen : TonWalletScreens("passcode_screen")
    object ConfirmPasscodeScreen : TonWalletScreens("confirm_passcode_screen")
    object ReadyToGoScreen : TonWalletScreens("ready_to_go_screen")
    object PinScreen : TonWalletScreens("pin_screen")
    object SendScreen : TonWalletScreens("send_screen")
    object SettingScreen : TonWalletScreens("setting_screen")
    object ScanQrCodeScreen : TonWalletScreens("scan_qr_code_screen")
}

