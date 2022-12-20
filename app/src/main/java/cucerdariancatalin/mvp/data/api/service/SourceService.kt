package cucerdariancatalin.mvp.data.api.service

import cucerdariancatalin.mvp.model.SourceResponse
import io.reactivex.Single
import retrofit2.http.GET

interface SourceService {

    @GET("sources")
    fun getSources() : Single<SourceResponse>

}