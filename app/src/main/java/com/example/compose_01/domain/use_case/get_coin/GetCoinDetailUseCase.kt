package com.example.compose_01.domain.use_case.get_coin

import com.example.compose_01.common.Resource
import com.example.compose_01.data.remote.dto.toCoin
import com.example.compose_01.data.remote.dto.toCoinDetail
import com.example.compose_01.domain.model.Coin
import com.example.compose_01.domain.model.CoinDetail
import com.example.compose_01.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.net.HttpRetryException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(id: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoin(id).toCoinDetail()
            emit(Resource.Success(coin))
        }catch (e: HttpRetryException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred!"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}