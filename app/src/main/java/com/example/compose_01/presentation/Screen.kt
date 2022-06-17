package com.example.compose_01.presentation

sealed class Screen(val route: String){
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
}
