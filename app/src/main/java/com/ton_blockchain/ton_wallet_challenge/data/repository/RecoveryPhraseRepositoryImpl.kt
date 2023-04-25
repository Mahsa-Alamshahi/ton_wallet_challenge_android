package com.ton_blockchain.ton_wallet_challenge.data.repository

import com.ton_blockchain.ton_wallet_challenge.data.data_source.RecoveryPhraseProvider
import com.ton_blockchain.ton_wallet_challenge.domain.repository.RecoveryPhraseRepository
import javax.inject.Inject


class RecoveryPhraseRepositoryImpl @Inject constructor(private val recoveryPhraseProvider: RecoveryPhraseProvider): RecoveryPhraseRepository  {
    override fun generateRecoveryPhrase(): Map<Int, String> =
      recoveryPhraseProvider.generateRecoveryPhrase()



}