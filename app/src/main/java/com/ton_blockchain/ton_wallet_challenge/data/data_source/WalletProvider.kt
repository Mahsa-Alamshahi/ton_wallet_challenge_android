package com.ton_blockchain.ton_wallet_challenge.data.data_source

import com.google.common.base.Joiner
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.BalanceDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.WalletDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.Balance
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.bitcoinj.core.NetworkParameters
import org.bitcoinj.params.MainNetParams
import org.bitcoinj.script.Script
import org.bitcoinj.wallet.DeterministicSeed
import org.bitcoinj.wallet.Wallet
import org.ton.mnemonic.Mnemonic
import java.util.Date
import javax.inject.Inject


class WalletProvider @Inject constructor(private val walletDao: WalletDao, private val balanceDao: BalanceDao) {


    fun generateWallet(
        seedCode: MutableList<String>, seedByteArray: ByteArray? = null
    ) {

        val passphrase = ""
        val creationtime = Date().time
        val seed = DeterministicSeed(seedCode, null, passphrase, creationtime)
        val params: NetworkParameters = MainNetParams.get()
        val wallet: Wallet? = Wallet.fromSeed(params, seed, Script.ScriptType.P2PKH)
        //  TestNet3Params.get()
        wallet?.let { insertWallet(it) }

        var ww = wallet?.walletTransactions
        println("seed *********** $wallet")
        println("seed *********** ${wallet!!.walletTransactions}")
        println("*********************************************************************************")
//        val seed2 = wallet.keyChainSeed
//        println("Seed words are: " + Joiner.on(" ").join(seed2.mnemonicCode))


    }


    fun restoreWallet(mnemonicList: List<String>) {
        val seedCode = Mnemonic.toSeed(mnemonicList)
        val creationtime = 1409478661L
        val params: NetworkParameters = MainNetParams.get()
        val seed = DeterministicSeed(mnemonicList, null, "", creationtime)
        val restoredWallet = Wallet.fromSeed(params, seed)
        restoredWallet?.let { insertWallet(it) }
    }


    private fun insertWallet(wallet: Wallet) {
        CoroutineScope(Dispatchers.IO).launch {
            walletDao.insertOrUpdate(createWalletEntity(wallet))
        }
    }


    private fun createWalletEntity(wallet: Wallet): WalletEntity {

        val seed = wallet.keyChainSeed
        println("Seed words are: " + Joiner.on(" ").join(seed.mnemonicCode))
        println("Seed birthday is: " + seed.creationTimeSeconds)

        CoroutineScope(Dispatchers.IO).launch {
            balanceDao.insertOrUpdate(Balance(
                estimated = wallet.getBalance(Wallet.BalanceType.ESTIMATED).toPlainString(),
                available = wallet.getBalance(Wallet.BalanceType.AVAILABLE).toPlainString(),
                estimatedSpendable = wallet.getBalance(Wallet.BalanceType.ESTIMATED_SPENDABLE)
                    .toPlainString(),
                availableSpendable = wallet.getBalance(Wallet.BalanceType.AVAILABLE_SPENDABLE)
                    .toPlainString()
            ))
        }

        return WalletEntity(
            seedBirthday = seed.creationTimeSeconds.toString(),
            address = wallet.currentReceiveAddress().toString(),
            earliestCreationTime = wallet.earliestKeyCreationTime.toString(),
            walletKey = wallet.currentReceiveKey().toString(),
            transaction = wallet.walletTransactions.toString())
        }

}

