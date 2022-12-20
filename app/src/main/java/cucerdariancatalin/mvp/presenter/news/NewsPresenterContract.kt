package cucerdariancatalin.mvp.presenter.news

import cucerdariancatalin.mvp.ui.news.NewsViewContract

interface NewsPresenterContract {

    fun setView(view: NewsViewContract)

    fun cancelLoadNews()

    fun loadNews(source: String)
}