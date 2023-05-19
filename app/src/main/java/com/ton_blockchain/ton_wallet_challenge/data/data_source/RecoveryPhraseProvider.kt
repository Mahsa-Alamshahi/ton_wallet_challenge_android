package com.ton_blockchain.ton_wallet_challenge.data.data_source

import android.util.Log
import org.ton.mnemonic.Mnemonic
import javax.inject.Inject


class RecoveryPhraseProvider @Inject constructor(private var walletProvider: WalletProvider) {


    suspend fun generateRecoveryPhrase(): MutableList<Pair<Int, String>> {

        val mnemonic = Mnemonic.generate()
        println(" MNEMONIC : " + mnemonic)

        val recoveryPhraseList = mutableListOf<Pair<Int, String>>()
        var seedCodeList: ArrayList<String> = ArrayList()
        var index = 1
        for (word in mnemonic) {
            recoveryPhraseList.add(Pair(index, word))
            seedCodeList.add(word)
            index++
        }
        val seedByteArray: ByteArray = Mnemonic.toSeed(mnemonic)
        walletProvider.generateWallet(seedCodeList, seedByteArray)
        return recoveryPhraseList
    }


    fun isSeedValid(seedWords: List<String>): Boolean {
        Log.d("mnemoniic", "Verifying seed ${seedWords.size}")

        seedWords.forEachIndexed { index, phrase ->
            println(phrase + "$index")
        }
        var isSeedPhraseValid = false
        try {
            Mnemonic.isValid(seedWords)
            isSeedPhraseValid = true
        } catch (e: Exception) {
            isSeedPhraseValid = false
        }
        return isSeedPhraseValid
    }


}