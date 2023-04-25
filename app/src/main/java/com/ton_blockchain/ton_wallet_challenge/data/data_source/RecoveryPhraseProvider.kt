package com.ton_blockchain.ton_wallet_challenge.data.data_source

import cash.z.ecc.android.bip39.Mnemonics


class RecoveryPhraseProvider {

    fun generateRecoveryPhrase(){
        val mnemonicCode: Mnemonics.MnemonicCode = Mnemonics.MnemonicCode(Mnemonics.WordCount.COUNT_24)
        for (word in mnemonicCode) {
            println(word)
        }
    }
}