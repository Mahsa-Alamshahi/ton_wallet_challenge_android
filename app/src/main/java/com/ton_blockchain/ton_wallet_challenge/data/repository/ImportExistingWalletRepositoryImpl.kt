package com.ton_blockchain.ton_wallet_challenge.data.repository

import com.ton_blockchain.ton_wallet_challenge.data.data_source.RecoveryPhraseProvider
import com.ton_blockchain.ton_wallet_challenge.data.data_source.WalletProvider
import com.ton_blockchain.ton_wallet_challenge.domain.repository.ImportExistingWalletRepository
import javax.inject.Inject


class ImportExistingWalletRepositoryImpl @Inject constructor(
    private val recoveryPhraseProvider: RecoveryPhraseProvider,
    private val walletProvider: WalletProvider
) :
    ImportExistingWalletRepository {


    override fun generateWallet(seedWords: MutableList<String>) {
        if (recoveryPhraseProvider.isSeedValid(seedWords))
//            walletProvider.generateWallet(seedWords)
            println("SEED WORDS ARE VALID.1 YeeesSsssSSs")
        println("SEED WORDS ARE VALID.2 YeeesSsssSSs")
    }
}

