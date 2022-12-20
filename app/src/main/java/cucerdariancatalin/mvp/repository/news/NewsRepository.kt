package cucerdariancatalin.mvp.repository.news

import cucerdariancatalin.mvp.model.NewsResponse
import io.reactivex.Single
import javax.inject.Inject

class NewsRepository @Inject
constructor(var remoteDataSource: NewsDataSource) : NewsDataSource {
    override fun getNews(source: String): Single<NewsResponse> {

        return remoteDataSource.getNews(source)
    }
}