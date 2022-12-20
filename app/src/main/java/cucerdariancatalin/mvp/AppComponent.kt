package cucerdariancatalin.mvp

import cucerdariancatalin.mvp.data.DataModule
import cucerdariancatalin.mvp.data.api.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = arrayOf(
        AppModule::class,
        NetworkModule::class,
        DataModule::class)
)

@Singleton
interface AppComponent : AppGraph {
}