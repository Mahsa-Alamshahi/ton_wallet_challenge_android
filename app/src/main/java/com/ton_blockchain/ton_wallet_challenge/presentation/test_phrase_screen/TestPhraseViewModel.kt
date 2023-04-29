package com.ton_blockchain.ton_wallet_challenge.presentation.test_phrase_screen

import androidx.lifecycle.ViewModel
import com.ton_blockchain.ton_wallet_challenge.domain.use_case.test_phrase_use_case.TestPhraseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TestPhraseViewModel @Inject constructor(private val testPhraseUseCase: TestPhraseUseCase): ViewModel() {

    fun generateThreeRandomNumber(): List<Int> = testPhraseUseCase()

}