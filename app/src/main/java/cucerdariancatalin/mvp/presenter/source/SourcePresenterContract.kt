package cucerdariancatalin.mvp.presenter.source

interface SourcePresenterContract {

    fun setView(view: SourceViewContract)

    fun cancelLoadSource()

    fun loadSource()
}