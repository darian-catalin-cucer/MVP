package cucerdariancatalin.mvp.repository.source

import cucerdariancatalin.mvp.model.SourceResponse
import io.reactivex.Single
import javax.inject.Inject

class SourceRepository @Inject
constructor(var remoteDataSource: RemoteSourceDataSource) : SourceDataSource {

    override fun getSource(): Single<SourceResponse> {
        return remoteDataSource.getSource()
    }
}