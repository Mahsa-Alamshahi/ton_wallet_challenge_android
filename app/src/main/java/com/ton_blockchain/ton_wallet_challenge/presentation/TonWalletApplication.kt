package com.ton_blockchain.ton_wallet_challenge.presentation

import androidx.multidex.MultiDexApplication
import com.orhanobut.hawk.Hawk
import dagger.hilt.android.HiltAndroidApp
import xyz.teamgravity.pin_lock_compose.PinManager


@HiltAndroidApp
class TonWalletApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        PinManager.initialize(this)
        Hawk.init(this).build()
    }

}