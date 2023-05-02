package com.ton_blockchain.ton_wallet_challenge.presentation

import androidx.multidex.MultiDexApplication
import com.orhanobut.hawk.Hawk
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class TonWalletApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
    }

}