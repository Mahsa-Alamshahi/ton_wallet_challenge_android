package com.ton_blockchain.ton_wallet_challenge.data.data_source

import cash.z.ecc.android.bip39.Mnemonics


class RecoveryPhraseProvider {

    fun generateRecoveryPhrase(): Map<Int, String> {
        val recoveryPhraseMap = mutableMapOf<Int, String>()
        val mnemonicCode: Mnemonics.MnemonicCode = Mnemonics.MnemonicCode(Mnemonics.WordCount.COUNT_24)
        var index = 1
        for (word in mnemonicCode) {
            recoveryPhraseMap[index] = word
            println("$index $word")
            index++
        }
        return recoveryPhraseMap
    }
}