package ar.com.thecoininspector.coininspector.data.remote

import ar.com.thecoininspector.coininspector.application.AppConstants
import ar.com.thecoininspector.coininspector.application.AppConstants.NEWS_BASE_URL
import ar.com.thecoininspector.coininspector.core.WebService
import ar.com.thecoininspector.coininspector.data.models.CoinArray
import ar.com.thecoininspector.coininspector.data.models.News
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinDataSource @Inject constructor (private val webService: WebService) {

    suspend fun getAllCoins(): CoinArray = webService.getAllCoins()


    suspend fun getAllNews(): News =
        webService.getNews(
            NEWS_BASE_URL)

}