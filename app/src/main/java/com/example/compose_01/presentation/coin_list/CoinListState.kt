package com.example.compose_01.presentation.coin_list

import com.example.compose_01.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coin: List<Coin> = emptyList(),
    val isError: String = ""
    )