package com.example.compose_01.domain.repository

import com.example.compose_01.data.remote.dto.CoinDetailDto
import com.example.compose_01.data.remote.dto.CoinDto
import com.example.compose_01.domain.model.Coin
import com.example.compose_01.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoin(id: String): CoinDetailDto
}