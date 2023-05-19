package com.ton_blockchain.ton_wallet_challenge.data.data_source

import java.util.Date


class WalletProvider {


    fun generateWallet(
        seedCode: MutableList<String>,
        seedByteArray: ByteArray? = null
    ) {

        val passphrase = ""
        val creationtime = Date().time
//        val seed = DeterministicSeed(seedCode, null, passphrase, creationtime)
//        val params: NetworkParameters = MainNetParams.get()
//        val wallet: Wallet? = Wallet.fromSeed(params, seed, Script.ScriptType.P2PKH)
        //  TestNet3Params.get()
//        val walletAddress: org.bitcoinj.core.Address? = wallet.currentReceiveAddress()
//        Hawk.put(Constants.HAWK_WALLET, wallet)

//        println("seed $wallet")

//        val seed2 = wallet.keyChainSeed
//        println("Seed words are: " + Joiner.on(" ").join(seed2.mnemonicCode))
    }




}

