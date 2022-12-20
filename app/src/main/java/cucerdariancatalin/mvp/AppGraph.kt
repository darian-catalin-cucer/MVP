package cucerdariancatalin.mvp

import cucerdariancatalin.mvp.ui.news.NewsActivity
import cucerdariancatalin.mvp.ui.source.SourceActivity

interface AppGraph {

    fun inject(app: App)

    fun inject(sourceActivity: SourceActivity)

    fun inject(newsActivity: NewsActivity)
}