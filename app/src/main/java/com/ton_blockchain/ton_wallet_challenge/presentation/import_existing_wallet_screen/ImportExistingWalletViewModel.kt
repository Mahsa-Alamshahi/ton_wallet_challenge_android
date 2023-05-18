package com.ton_blockchain.ton_wallet_challenge.presentation.import_existing_wallet_screen

import androidx.lifecycle.ViewModel
import com.ton_blockchain.ton_wallet_challenge.domain.use_case.import_existing_wallet_use_case.ImportExistingWalletUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class ImportExistingWalletViewModel @Inject constructor(private val importExistingWalletUseCase: ImportExistingWalletUseCase) :
    ViewModel() {


//   val _state = mutableStateOf(RestoreWalletState())
//    var state: State<RestoreWalletState> = _state

    private val _state = MutableStateFlow(RestoreWalletState(isLoading = true))
    val state: StateFlow<RestoreWalletState> = _state


    //    fun generateWalletAddress(phraseList: MutableList<String>) {
//
//        importExistingWalletUseCase(phraseList).onEach {result ->
//            when(result) {
//                is Resource.Loading ->{
//                    _state.value = RestoreWalletState(isLoading = true)
//                }
//                is Resource.Success ->{
//                    _state.value = RestoreWalletState(isWalletRestored = result.data ?: false)
//                }
//                is Resource.Error ->{
//                    _state.value = RestoreWalletState(error = result.message ?: "An unexpected error occured." )
//                }
//            }
//
//        }
//
//
//    }
    fun generateWalletAddress(phraseList: MutableList<String>): Boolean {

        return importExistingWalletUseCase(phraseList)


    }
}