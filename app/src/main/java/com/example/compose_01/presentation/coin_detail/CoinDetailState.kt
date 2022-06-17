package com.example.compose_01.presentation.coin_detail

import com.example.compose_01.domain.model.Coin
import com.example.compose_01.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val isError: String = ""
    )