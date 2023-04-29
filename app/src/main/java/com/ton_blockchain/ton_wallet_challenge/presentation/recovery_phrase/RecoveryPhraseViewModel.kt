package com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.ton_blockchain.ton_wallet_challenge.domain.use_case.recovery_phrase_use_case.RecoveryPhraseGeneratorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class RecoveryPhraseViewModel @Inject constructor(private val recoveryPhraseGeneratorUseCase: RecoveryPhraseGeneratorUseCase) :
    ViewModel() {

     val _state = mutableStateListOf<Pair<Int, String>>()

    init {
        generateRecoveryPhrase()
    }

    private fun generateRecoveryPhrase() {
        _state.addAll(recoveryPhraseGeneratorUseCase())
    }

}


