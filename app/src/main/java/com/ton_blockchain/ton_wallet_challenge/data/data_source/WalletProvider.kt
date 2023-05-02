package com.ton_blockchain.ton_wallet_challenge.data.data_source

import com.orhanobut.hawk.Hawk
import com.ton_blockchain.ton_wallet_challenge.common.Constants
import org.bitcoinj.core.Address
import org.bitcoinj.core.NetworkParameters
import org.bitcoinj.params.MainNetParams
import org.bitcoinj.script.Script
import org.bitcoinj.wallet.DeterministicSeed
import org.bitcoinj.wallet.Wallet
import java.util.Date

class WalletProvider {


    fun generateWalletAddress(mnemonicString: String, seedByteArray: ByteArray) {

        val passphrase = ""
        val creationtime = Date().time
        //  TestNet3Params.get()
        val seed = DeterministicSeed(mnemonicString, seedByteArray, passphrase, creationtime)
        val params: NetworkParameters = MainNetParams.get()
        val wallet: Wallet = Wallet.fromSeed(params, seed, Script.ScriptType.P2PKH)

        var walletAddress: Address = wallet.currentReceiveAddress()
        Hawk.put(Constants.HAWK_WALLET_ADDRESS, walletAddress)

//        val seed2 = wallet.keyChainSeed
//        println("Seed words are: " + Joiner.on(" ").join(seed2.mnemonicCode))
    }
}