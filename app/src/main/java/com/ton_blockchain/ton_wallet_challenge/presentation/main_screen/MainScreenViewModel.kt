package com.ton_blockchain.ton_wallet_challenge.presentation.main_screen

import androidx.lifecycle.ViewModel
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.Balance
import com.ton_blockchain.ton_wallet_challenge.domain.use_case.database_use_case.GetBalanceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(private val getBalanceUseCase: GetBalanceUseCase): ViewModel() {

    suspend fun getBalance(): List<Balance> = getBalanceUseCase()
}