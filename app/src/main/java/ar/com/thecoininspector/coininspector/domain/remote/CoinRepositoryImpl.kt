package ar.com.thecoininspector.coininspector.domain.remote

import ar.com.thecoininspector.coininspector.data.models.CoinArray
import ar.com.thecoininspector.coininspector.data.models.News
import ar.com.thecoininspector.coininspector.data.remote.CoinDataSource
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor (private val dataSource: CoinDataSource):CoinRepository {

    override suspend fun getCoins(): CoinArray = dataSource.getAllCoins()

    override suspend fun getNews(): News = dataSource.getAllNews()
}