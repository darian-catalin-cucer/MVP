package cucerdariancatalin.mvp.presenter.news

interface NewsPresenterContract {

    fun setView(view: NewsViewContract)

    fun cancelLoadNews()

    fun loadNews(source: String)
}