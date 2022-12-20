package cucerdariancatalin.mvp.presenter.news

import cucerdariancatalin.mvp.data.scheduler.SchedulerInterface
import cucerdariancatalin.mvp.repository.news.NewsRepository
import cucerdariancatalin.mvp.ui.news.NewsViewContract
import io.reactivex.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject

class NewsPresenter @Inject
constructor(private val repository: NewsRepository,
            private val schedulerProvider: SchedulerInterface
) : NewsPresenterContract {

    private lateinit var view: NewsViewContract
    private var disposable: Disposable? = null

    override fun setView(view: NewsViewContract) {
        this.view = view
    }

    override fun cancelLoadNews() {
        Timber.i("Dispose")

        disposable?.let {
            if(!disposable!!.isDisposed) {
                disposable!!.dispose()
                disposable = null
            }
        }
    }

    override fun loadNews(source: String) {
        disposable = repository.getNews(source)
            .observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .subscribe({ news ->
                view.showNews(news)
            }, {
                view.handleError()
            })
    }

}