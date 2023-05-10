package com.ton_blockchain.ton_wallet_challenge.presentation.main_screen

import androidx.lifecycle.ViewModel
import com.orhanobut.hawk.Hawk
import com.ton_blockchain.ton_wallet_challenge.common.Constants.HAWK_WALLET
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(): ViewModel() {



    fun showBalance(): String {
        Hawk.put(HAWK_WALLET, "UQD1yQ3tV5Ab1EKFfQXdZiYlAV_yaT6fNogQtXK1vFR2tsgZ")
        var balance = ""
        if (Hawk.get(HAWK_WALLET, null) != null) {
//            val wallet: Wallet = Hawk.get(HAWK_WALLET)
//            balance = wallet.balance.toString()
        } else {
            balance = "0.0"
        }
        return balance
    }
}