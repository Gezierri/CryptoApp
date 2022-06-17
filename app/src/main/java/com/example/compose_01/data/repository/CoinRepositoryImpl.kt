package com.example.compose_01.data.repository

import com.example.compose_01.data.remote.CoinPaprikaApi
import com.example.compose_01.data.remote.dto.CoinDetailDto
import com.example.compose_01.data.remote.dto.CoinDto
import com.example.compose_01.domain.model.Coin
import com.example.compose_01.domain.model.CoinDetail
import com.example.compose_01.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val paprikaApi: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return paprikaApi.getCoins()
    }

    override suspend fun getCoin(id: String): CoinDetailDto {
        return paprikaApi.getCoin(id)
    }
}