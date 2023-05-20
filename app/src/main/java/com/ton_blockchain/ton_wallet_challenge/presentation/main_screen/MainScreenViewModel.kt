package com.ton_blockchain.ton_wallet_challenge.presentation.main_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(): ViewModel() {



    fun showBalance(): String {
//        HAWK_WALLET Hawk.put(, "UQD1yQ3tV5Ab1EKFfQXdZiYlAV_yaT6fNogQtXK1vFR2tsgZ")
        var balance = ""
//        if (Hawk.get(HAWK_WALLET, null) != null) {
////            val wallet: Wallet = Hawk.get(HAWK_WALLET)
////            balance = wallet.balance.toString()
//        } else {
//            balance = "0.0"
//        }
        return balance
    }
}