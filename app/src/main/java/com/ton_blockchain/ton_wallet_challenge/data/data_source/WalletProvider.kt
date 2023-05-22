package com.ton_blockchain.ton_wallet_challenge.data.data_source

import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.WalletDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.bitcoinj.core.NetworkParameters
import org.bitcoinj.params.MainNetParams
import org.bitcoinj.script.Script
import org.bitcoinj.wallet.DeterministicSeed
import org.bitcoinj.wallet.Wallet
import java.util.Date
import javax.inject.Inject


class WalletProvider @Inject constructor(private val walletDao: WalletDao) {


    fun generateWallet(
        seedCode: MutableList<String>, seedByteArray: ByteArray? = null
    ) {

        val passphrase = ""
        val creationtime = Date().time
        val seed = DeterministicSeed(seedCode, null, passphrase, creationtime)
        val params: NetworkParameters = MainNetParams.get()
        val wallet: Wallet? = Wallet.fromSeed(params, seed, Script.ScriptType.P2PKH)
        //  TestNet3Params.get()
//        val walletAddress: org.bitcoinj.core.Address? = wallet?.currentReceiveAddress()
        wallet?.let { insertWallet(it) }
        println("seed *********** $wallet")
        println("*********************************************************************************")
//        val seed2 = wallet.keyChainSeed
//        println("Seed words are: " + Joiner.on(" ").join(seed2.mnemonicCode))


    }


    private fun insertWallet(wallet: Wallet) {
        CoroutineScope(Dispatchers.IO).launch {
            walletDao.insertOrUpdate(createWalletEntity(wallet))
        }
    }


    private fun createWalletEntity(wallet: Wallet): WalletEntity {
       return WalletEntity(
            balance = wallet.balance.toString(),
            seedBirthday = "",
        address = wallet.currentReceiveAddress().toString(),
        earliestCreationTime = "",
        walletKey = wallet.currentReceiveKey().toString(),
        transaction = wallet.walletTransactions.toString())
    }

}

