package ar.com.thecoininspector.coininspector.core

import ar.com.thecoininspector.coininspector.data.models.CoinList
import retrofit2.http.GET

interface WebService {

    @GET("coins")
    suspend fun getAllCoins():CoinList

}