package ar.com.thecoininspector.coininspector.domain.remote

import ar.com.thecoininspector.coininspector.data.models.CoinArray

interface CoinRepository {

    suspend fun getCoins(): CoinArray

}