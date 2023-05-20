package com.ton_blockchain.ton_wallet_challenge.presentation.wallet_created

import androidx.lifecycle.ViewModel
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity
import com.ton_blockchain.ton_wallet_challenge.domain.use_case.wallet_use_case.GetWalletsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WalletCreatedViewModel @Inject constructor(private val getWalletsUseCase: GetWalletsUseCase): ViewModel(){

    suspend fun getWallets(): List<WalletEntity> = getWalletsUseCase()
}