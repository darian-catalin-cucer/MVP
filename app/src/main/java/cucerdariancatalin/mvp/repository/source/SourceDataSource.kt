package cucerdariancatalin.mvp.repository.source

import cucerdariancatalin.mvp.model.SourceResponse
import io.reactivex.Single

interface SourceDataSource {

    fun getSource(): Single<SourceResponse>
}
