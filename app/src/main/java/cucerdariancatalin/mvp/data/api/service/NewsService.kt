package cucerdariancatalin.mvp.data.api.service

import cucerdariancatalin.mvp.model.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("articles")
    fun getNews(@Query("source") source: String,
                @Query("apiKey") apiKey: String) : Single<NewsResponse>
}