package com.ton_blockchain.ton_wallet_challenge.domain.use_case.recovery_phrase_use_case

import com.ton_blockchain.ton_wallet_challenge.domain.repository.RecoveryPhraseRepository
import javax.inject.Inject

class RecoveryPhraseGeneratorUseCase @Inject constructor(private val recoveryPhraseRepository: RecoveryPhraseRepository) {

    operator fun invoke(): List<Pair<Int, String>> = recoveryPhraseRepository.generateRecoveryPhrase()
}