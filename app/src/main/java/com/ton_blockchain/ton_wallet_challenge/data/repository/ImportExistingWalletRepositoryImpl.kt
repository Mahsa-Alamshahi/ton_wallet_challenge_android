package com.ton_blockchain.ton_wallet_challenge.data.repository

import com.orhanobut.logger.Logger
import com.ton_blockchain.ton_wallet_challenge.data.data_source.RecoveryPhraseProvider
import com.ton_blockchain.ton_wallet_challenge.data.data_source.WalletProvider
import com.ton_blockchain.ton_wallet_challenge.domain.repository.ImportExistingWalletRepository
import javax.inject.Inject


class ImportExistingWalletRepositoryImpl @Inject constructor(
    private val recoveryPhraseProvider: RecoveryPhraseProvider,
    private val walletProvider: WalletProvider
) :
    ImportExistingWalletRepository {


    override fun generateWallet(seedWords: MutableList<String>): Boolean {
        Logger.d(recoveryPhraseProvider.isSeedValid(seedWords))
        return if (recoveryPhraseProvider.isSeedValid(seedWords)) {
            walletProvider.generateWallet(seedWords)
            println("SEED WORDS ARE VALID.1 YeeesSsssSSs")
            true
        } else {
            println("SEED WORDS ARE VALID.2 NoooOoOoooOo")
            false
        }
    }

    override fun restoreWallet(mnemonicList: MutableList<String>): Boolean {
        Logger.d(recoveryPhraseProvider.isSeedValid(mnemonicList))
        return if (recoveryPhraseProvider.isSeedValid(mnemonicList)) {
            walletProvider.restoreWallet(mnemonicList)
            println("SEED WORDS ARE VALID.1 YeeesSsssSSs")
            true
        } else {
            println("SEED WORDS ARE VALID.2 NoooOoOoooOo")
            false
        }
    }
}

