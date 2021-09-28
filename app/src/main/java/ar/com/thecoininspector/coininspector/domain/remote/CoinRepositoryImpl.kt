package ar.com.thecoininspector.coininspector.domain.remote

import ar.com.thecoininspector.coininspector.data.models.Coin
import ar.com.thecoininspector.coininspector.data.models.CoinList
import ar.com.thecoininspector.coininspector.data.remote.CoinDataSource
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor (private val dataSource: CoinDataSource):CoinRepository {
    override suspend fun getCoins(): CoinList = dataSource.getAllCoins()
}