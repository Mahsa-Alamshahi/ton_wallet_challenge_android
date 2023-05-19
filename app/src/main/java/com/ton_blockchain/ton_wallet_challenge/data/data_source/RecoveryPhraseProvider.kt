package com.ton_blockchain.ton_wallet_challenge.data.data_source

import android.util.Log
import org.ton.mnemonic.Mnemonic
import javax.inject.Inject


class RecoveryPhraseProvider @Inject constructor(private var walletProvider: WalletProvider){



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
        Log.d("mnemoniic","Verifying seed ${seedWords.size}")

        seedWords.forEachIndexed {index, phrase ->
            println(phrase + "$index")
        }
        var isSeedPhraseValid = false
        try {
            Mnemonic.isValid(seedWords)
//            MnemonicCode.INSTANCE.check(seedWords)
            isSeedPhraseValid = true
        } catch (e: Exception) {

        }
//        } catch (e: MnemonicException.MnemonicChecksumException) {
//            Log.d("Checksum error in seed:  {}", "MnemonicChecksumException " + e.message.toString())
//        } catch (e: MnemonicException.MnemonicWordException) {
//            Log.d("Unknown words in seed:  {}", "MnemonicWordException "+ e.message.toString())
//        } catch (e: MnemonicException) {
//            Log.d("Error verifying seed: {}", "MnemonicException " + e.message.toString())
//        }
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