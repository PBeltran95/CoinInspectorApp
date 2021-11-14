package ar.com.thecoininspector.coininspector.domain.remote

import ar.com.thecoininspector.coininspector.data.models.CoinArray
import ar.com.thecoininspector.coininspector.data.models.News

interface CoinRepository {

    suspend fun getCoins(): CoinArray

    suspend fun getNews():News

}