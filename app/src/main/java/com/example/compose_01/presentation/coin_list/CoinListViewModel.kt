package com.example.compose_01.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_01.common.Resource
import com.example.compose_01.domain.use_case.get_list_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinsUseCase: GetCoinsUseCase
): ViewModel(){

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        coinsUseCase().onEach {result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinListState(coin = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(true)
                }
                is  Resource.Error -> {
                    _state.value = CoinListState(isError = "An unexpected error occurred!")
                }
            }
        }.launchIn(viewModelScope)
    }
}