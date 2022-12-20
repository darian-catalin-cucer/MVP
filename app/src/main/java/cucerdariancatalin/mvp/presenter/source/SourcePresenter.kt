package cucerdariancatalin.mvp.presenter.source

import cucerdariancatalin.mvp.data.scheduler.SchedulerInterface
import cucerdariancatalin.mvp.repository.source.SourceRepository
import cucerdariancatalin.mvp.ui.source.SourceViewContract
import io.reactivex.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject

class SourcePresenter @Inject
constructor(private val repository: SourceRepository,
            private val schedulerProvider: SchedulerInterface
): SourcePresenterContract {

    private lateinit var view: SourceViewContract
    private var disposable: Disposable? = null

    override fun setView(view: SourceViewContract) {
        this.view = view
    }

    override fun cancelLoadSource() {
        Timber.i("Dispose")

        disposable?.let {
            if (!disposable!!.isDisposed) {
                disposable!!.dispose()
                disposable = null
            }
        }
    }

    override fun loadSource() {
        disposable = repository.getSource()
            .observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .subscribe({
                    sources -> view.showSources(sources) }, {
            })
    }
}