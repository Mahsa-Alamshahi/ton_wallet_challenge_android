package com.ton_blockchain.ton_wallet_challenge.domain.repository

interface ImportExistingWalletRepository {

    fun generateWallet(mnemonicString: MutableList<String>): Boolean
    fun restoreWallet(mnemonicString: MutableList<String>): Boolean
}