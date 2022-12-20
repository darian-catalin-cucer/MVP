package cucerdariancatalin.mvp.repository.news

import cucerdariancatalin.mvp.model.NewsResponse
import io.reactivex.Single

interface NewsDataSource {

    fun getNews(source: String): Single<NewsResponse>
}