package ar.com.thecoininspector.coininspector.data.models

data class Coin(
    val id: String = "",
    val name: String = "",
    val symbol:String = "",
    val rank:Int = 0,
    val isNew:Boolean = false,
    val isActive:Boolean = true,
    val type: String = ""
                    )

data class CoinList(
    val result: List<Coin>
)
