package com.ton_blockchain.ton_wallet_challenge.presentation.test_phrase_screen

import androidx.lifecycle.ViewModel
import com.ton_blockchain.ton_wallet_challenge.domain.use_case.test_phrase_use_case.CheckRandomPhraseUseCase
import com.ton_blockchain.ton_wallet_challenge.domain.use_case.test_phrase_use_case.GenerateRandomNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TestPhraseViewModel @Inject constructor(
    private val generateRandomNumberUseCase: GenerateRandomNumberUseCase,
    private val checkRandomPhraseUseCase: CheckRandomPhraseUseCase,
) :
    ViewModel() {

    fun generateThreeRandomNumber(): List<Int> = generateRandomNumberUseCase()
    fun checkRandomPhrase(phraseList: List<Pair<Int, String>>, inputPhraseList: MutableList<Pair<Int, String>>): Boolean =
        checkRandomPhraseUseCase(phraseList, inputPhraseList)



}