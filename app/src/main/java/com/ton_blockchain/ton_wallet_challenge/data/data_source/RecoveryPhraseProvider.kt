package com.ton_blockchain.ton_wallet_challenge.data.data_source

import android.util.Log
import cash.z.ecc.android.bip39.Mnemonics
import cash.z.ecc.android.bip39.toSeed
import org.bitcoinj.crypto.MnemonicCode
import org.bitcoinj.crypto.MnemonicException
import javax.inject.Inject


class RecoveryPhraseProvider @Inject constructor(private var walletProvider: WalletProvider){



    fun generateRecoveryPhrase(): List<Pair<Int, String>> {

        val recoveryPhraseList = mutableListOf<Pair<Int, String>>()
        val mnemonicCode: Mnemonics.MnemonicCode =
            Mnemonics.MnemonicCode(Mnemonics.WordCount.COUNT_24)
        var index = 1
        var mnemonicString = ""
        for (word in mnemonicCode) {
            mnemonicString += "$word "
            recoveryPhraseList.add(Pair(index, word))
            index++
        }
        val seedByteArray: ByteArray = mnemonicCode.toSeed()
        mnemonicString = mnemonicString.dropLast(1)
//        walletProvider.generateWalletAddress(mnemonicString, seedByteArray)
        return recoveryPhraseList
    }



    fun parseMnemonic(seedString: String): List<String> =
        seedString.split(" ").toList()



    fun isSeedValid(seedWords: List<String>): Boolean {
        Log.d("mnemoniic","Verifying seed ${seedWords.size}")

        seedWords.forEachIndexed {index, phrase ->
            println(phrase + "$index") }
        var isSeedPhraseValid = false
        try {
            MnemonicCode.INSTANCE.check(seedWords)
            isSeedPhraseValid = true
        } catch (e: MnemonicException.MnemonicChecksumException) {
            Log.d("Checksum error in seed:  {}", "MnemonicChecksumException " + e.message.toString())
        } catch (e: MnemonicException.MnemonicWordException) {
            Log.d("Unknown words in seed:  {}", "MnemonicWordException "+ e.message.toString())
        } catch (e: MnemonicException) {
            Log.d("Error verifying seed: {}", "MnemonicException " + e.message.toString())
        }
//        if (isSeedPhraseValid && seed != null) {
//            Log.d("ffff","Typed seed does not match the generated one.")
//            isSeedPhraseValid = false
//        }
        return isSeedPhraseValid
    }


    fun generateSeedFromExistingMnemonic(preExistingPhraseString: String){
//        val preExistingPhraseString = "scheme spot photo card baby mountain device kick cradle pact join borrow"
//       var seed = MnemonicCode(Mnemonics.WordCount.COUNT_24, preExistingPhraseString).toSeed()
    }

}