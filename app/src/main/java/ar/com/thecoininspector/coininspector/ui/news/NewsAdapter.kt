package ar.com.thecoininspector.coininspector.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ar.com.thecoininspector.coininspector.R
import ar.com.thecoininspector.coininspector.data.models.Result
import ar.com.thecoininspector.coininspector.databinding.NewsItemBinding
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var listOfNews: MutableList<Result> = mutableListOf()

    fun setData(newList: MutableList<Result>){
        this.listOfNews = newList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(layoutInflater.inflate(R.layout.news_item, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val new = listOfNews[position]
        with(holder.binding){
            tvTitle.text = new.title
            tvDescription.text = new.description
        }
    }

    override fun getItemCount(): Int = listOfNews.size



    inner class NewsViewHolder(view:View): RecyclerView.ViewHolder(view){
        val binding = NewsItemBinding.bind(view)
    }

}