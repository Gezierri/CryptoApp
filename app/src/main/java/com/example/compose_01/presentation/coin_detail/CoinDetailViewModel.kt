package com.example.compose_01.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_01.common.Constants.Companion.PARAM_COIN_ID
import com.example.compose_01.common.Resource
import com.example.compose_01.domain.use_case.get_coin.GetCoinDetailUseCase
import com.example.compose_01.domain.use_case.get_list_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinDetailUseCase: GetCoinDetailUseCase,
    handle: SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        handle.get<String>(PARAM_COIN_ID)?.let { id ->
            getCoinDetail(id)
        }
    }

    private fun getCoinDetail(id: String){
        coinDetailUseCase(id).onEach {result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(true)
                }
                is  Resource.Error -> {
                    _state.value = CoinDetailState(isError = "An unexpected error occurred!")
                }
            }
        }.launchIn(viewModelScope)
    }
}