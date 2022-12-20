package cucerdariancatalin.mvp.repository.source

import cucerdariancatalin.mvp.data.api.service.SourceService
import cucerdariancatalin.mvp.model.SourceResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteSourceDataSource @Inject
constructor(var sourceService: SourceService) : SourceDataSource {

    override fun getSource(): Single<SourceResponse> {
        return sourceService.getSources()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}
