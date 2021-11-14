package ar.com.thecoininspector.coininspector.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import ar.com.thecoininspector.coininspector.data.models.Coin

class DiffUtils(
    private val oldList: ArrayList<Coin>,
    private val newList: ArrayList<Coin>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].uuid == newList[newItemPosition].uuid &&
                oldList[oldItemPosition].name == newList[newItemPosition].name &&
                oldList[oldItemPosition].iconUrl == newList[newItemPosition].iconUrl
    }
}