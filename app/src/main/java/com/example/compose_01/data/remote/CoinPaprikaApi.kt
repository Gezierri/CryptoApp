package com.example.compose_01.data.remote

import com.example.compose_01.data.remote.dto.CoinDetailDto
import com.example.compose_01.data.remote.dto.CoinDto
import com.example.compose_01.domain.model.Coin
import com.example.compose_01.domain.model.CoinDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coin_id}")
    suspend fun getCoin(
        @Path("coin_id")
        id: String
    ): CoinDetailDto
}