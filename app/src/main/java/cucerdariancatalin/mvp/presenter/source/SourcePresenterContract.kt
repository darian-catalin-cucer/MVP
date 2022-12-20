package cucerdariancatalin.mvp.presenter.source

import cucerdariancatalin.mvp.ui.source.SourceViewContract

interface SourcePresenterContract {

    fun setView(view: SourceViewContract)

    fun cancelLoadSource()

    fun loadSource()
}