package ar.com.thecoininspector.coininspector.ui.home.adapter

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ar.com.thecoininspector.coininspector.R
import ar.com.thecoininspector.coininspector.data.models.Coin
import ar.com.thecoininspector.coininspector.databinding.ItemCoinBinding
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest

class HomeAdapter(val coins:ArrayList<Coin>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private lateinit var context:Context



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
                tvCoinBtcPrice.text = String.format("BTC: %.6f", coinPriceInBtc)
                tvCoinMarketCap.text = "Marketcap: \$${item.marketCap}"
                val coinPrice = item.price.toFloat()
                tvCoinPrice.text = String.format("\$ %.2f", coinPrice )
                tvRank.text = "#${item.rank}"
            }
        }
    }

    private fun ImageView.loadUrl(url:String) {
        val imageLoader = ImageLoader.Builder(context)
            .componentRegistry { add(SvgDecoder(context)) }
            .build()

        val request = ImageRequest.Builder(context)
            .crossfade(true)
            .crossfade(500)
            .data(url)
            .target(this)
            .build()

        imageLoader.enqueue(request)

    }

    override fun getItemCount(): Int = coins.size


    inner class HomeViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val binding = ItemCoinBinding.bind(view)
    }
}