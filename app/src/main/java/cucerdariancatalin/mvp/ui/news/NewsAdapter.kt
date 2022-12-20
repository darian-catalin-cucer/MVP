package cucerdariancatalin.mvp.ui.news

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import cucerdariancatalin.mvp.R
import cucerdariancatalin.mvp.model.NewsResponse
import cucerdariancatalin.mvp.widget.viewholder.NewsViewHolder

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>() {
    private var items : List<NewsResponse.News>? = null

    fun setItems(items: List<NewsResponse.News>?) {
        this.items = items
        notifyItemRangeInserted(0, items!!.size)
    }

    fun clearItems() {
        val count = itemCount
        this.items = null
        notifyItemRangeRemoved(0, count)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindView(items!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.view_news_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items?.size ?:0
    }
}
