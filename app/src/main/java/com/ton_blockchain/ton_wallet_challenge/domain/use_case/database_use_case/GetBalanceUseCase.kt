package com.ton_blockchain.ton_wallet_challenge.domain.use_case.database_use_case

import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.Balance
import com.ton_blockchain.ton_wallet_challenge.domain.repository.DatabaseRepository
import javax.inject.Inject

class GetBalanceUseCase @Inject constructor(private val databaseRepository: DatabaseRepository) {

    suspend operator fun invoke(): List<Balance> = databaseRepository.getBalances()
}