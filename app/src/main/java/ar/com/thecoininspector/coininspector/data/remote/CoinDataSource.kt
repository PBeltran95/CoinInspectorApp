package ar.com.thecoininspector.coininspector.data.remote

import ar.com.thecoininspector.coininspector.core.WebService
import ar.com.thecoininspector.coininspector.data.models.Coin
import ar.com.thecoininspector.coininspector.data.models.CoinList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinDataSource @Inject constructor (private val webService: WebService) {

    suspend fun getAllCoins(): CoinList = webService.getAllCoins()

}