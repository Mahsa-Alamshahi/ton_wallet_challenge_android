package com.ton_blockchain.ton_wallet_challenge.presentation.import_existing_wallet_screen

data class RestoreWalletState(
    val isLoading: Boolean = false, val isWalletRestored: Boolean = false, val error: String = ""
)
