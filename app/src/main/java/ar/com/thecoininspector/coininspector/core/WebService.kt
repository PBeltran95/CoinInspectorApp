package ar.com.thecoininspector.coininspector.core

import ar.com.thecoininspector.coininspector.data.models.CoinArray
import retrofit2.http.GET
import retrofit2.http.Headers

interface WebService {


    @Headers("x-access-token: coinranking64d9755d73692ba996ee489a9844709870922202d896ea73")
    @GET("coins")
    suspend fun getAllCoins():CoinArray

}