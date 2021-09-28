package ar.com.thecoininspector.coininspector.domain.remote

import ar.com.thecoininspector.coininspector.data.models.CoinList

interface CoinRepository {

    suspend fun getCoins(): CoinList

}