package ar.com.thecoininspector.coininspector.data.models

import com.google.gson.annotations.SerializedName


data class CoinArray(
    val status:String = "",
    val data: Data
)

data class Data(
    val stats:Stat,
    val coins:ArrayList<Coin>
)
data class Stat(
    val total: Int = 0,
    val totalCoins: Int = 0,
    val totalMarkets: Int = 0,
    val totalExchanges: Int = 0,
    val totalMarketCap: String = "",
    val total24hVolume: String = "",

)

data class Coin(
    val uuid: String = "",
    val symbol: String = "",
    val name: String = "",
    val color:String = "",
    val iconUrl:String = "",
    val marketCap:String = "",
    val price:String = "",
    val btcPrice:String = "",
    val change:String = "",
    val rank:Int = 0,
                    )


