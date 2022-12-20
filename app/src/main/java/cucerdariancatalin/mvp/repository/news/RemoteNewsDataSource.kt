package cucerdariancatalin.mvp.repository.news

import cucerdariancatalin.mvp.data.api.service.NewsService
import cucerdariancatalin.mvp.model.NewsResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteNewsDataSource @Inject
constructor(var newsService: NewsService): NewsDataSource {

    val API_KEY = "a67c7cdaf80644908b3df94747642471"

    override fun getNews(source: String): Single<NewsResponse> {
        return newsService.getNews(source, API_KEY)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}