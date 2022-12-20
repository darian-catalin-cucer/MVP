package cucerdariancatalin.mvp.ui.news

import cucerdariancatalin.mvp.model.NewsResponse

interface NewsViewContract {

    fun showNews(list: NewsResponse)

    fun handleError()

    fun getCurrentSource(): String
}