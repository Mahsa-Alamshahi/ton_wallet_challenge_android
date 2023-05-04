package com.ton_blockchain.ton_wallet_challenge.data.data_source

import cash.z.ecc.android.bip39.Mnemonics
import cash.z.ecc.android.bip39.toSeed
import javax.inject.Inject


class RecoveryPhraseProvider @Inject constructor(private var walletProvider: WalletProvider){



    fun generateRecoveryPhrase(): List<Pair<Int, String>> {

        val recoveryPhraseList = mutableListOf<Pair<Int, String>>()
        val mnemonicCode: Mnemonics.MnemonicCode =
            Mnemonics.MnemonicCode(Mnemonics.WordCount.COUNT_24)
        var index = 1
        var mnemonicString = ""

        for (word in mnemonicCode) {
            println("${index} $word")
            mnemonicString += "$word "
            recoveryPhraseList.add(Pair(index, word))
            index++
        }

        val seedByteArray: ByteArray = mnemonicCode.toSeed()
        mnemonicString = mnemonicString.dropLast(1)

        walletProvider.generateWalletAddress(mnemonicString, seedByteArray)

        return recoveryPhraseList
    }



}