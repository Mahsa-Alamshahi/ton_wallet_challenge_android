package com.ton_blockchain.ton_wallet_challenge.data.data_source

import cash.z.ecc.android.bip39.Mnemonics


class RecoveryPhraseProvider {

    fun generateRecoveryPhrase(): List<Pair<Int, String>> {
        val recoveryPhraseList = mutableListOf<Pair<Int, String>>()
        val mnemonicCode: Mnemonics.MnemonicCode =
            Mnemonics.MnemonicCode(Mnemonics.WordCount.COUNT_24)
        var index = 1
        for (word in mnemonicCode) {
            println("${index} $word")
            recoveryPhraseList.add(Pair(index, word))
            index++
        }
        return recoveryPhraseList
    }


}