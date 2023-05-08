package com.ton_blockchain.ton_wallet_challenge.presentation.import_existing_wallet_screen

import androidx.lifecycle.ViewModel
import com.ton_blockchain.ton_wallet_challenge.domain.use_case.import_existing_wallet_use_case.ImportExistingWalletUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ImportExistingWalletViewModel @Inject constructor(private val importExistingWalletUseCase: ImportExistingWalletUseCase) :
    ViewModel() {


    fun generateWalletAddress(phraseList: MutableList<String>) {
        importExistingWalletUseCase(phraseList)
    }
}