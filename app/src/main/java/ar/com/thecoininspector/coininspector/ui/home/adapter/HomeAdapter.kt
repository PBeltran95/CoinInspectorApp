package ar.com.thecoininspector.coininspector.ui.home.adapter

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.thecoininspector.coininspector.R
import ar.com.thecoininspector.coininspector.data.models.Coin
import ar.com.thecoininspector.coininspector.databinding.ItemCoinBinding
import ar.com.thecoininspector.coininspector.utils.loadUrl
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var coins:ArrayList<Coin> = arrayListOf()

    private lateinit var context:Context

    fun setData(newList: ArrayList<Coin>){
        val diffUtils = DiffUtils(coins, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtils)
        this.coins = newList
        diffResult.dispatchUpdatesTo(this)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        context = parent.context
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(layoutInflater.inflate(R.layout.item_coin,parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val item = coins[position]
        with(holder){
            val imageView = binding.imgCoin
            imageView.loadUrl(item.iconUrl)
            with(binding){
                tvCoinName.text = item.name
                val coinPriceInBtc = item.btcPrice.toFloat()
                val coinPrice = item.price.toFloat()
                tvCoinBtcPrice.text = String.format("BTC: %.6f", coinPriceInBtc)
                tvCoinMarketCap.text = context.getString(R.string.marketCap, item.marketCap)
                tvCoinPrice.text = String.format("\$ %.2f", coinPrice )
                tvRank.text = context.getString(R.string.coinRanking, item.rank)
            }
        }
    }



    override fun getItemCount(): Int = coins.size


    inner class HomeViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val binding = ItemCoinBinding.bind(view)
    }
}