package cucerdariancatalin.mvp.ui.source

import cucerdariancatalin.mvp.model.SourceResponse

interface SourceViewContract {

    fun showSources(list: SourceResponse)
}