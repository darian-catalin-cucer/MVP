package cucerdariancatalin.mvp.data

import cucerdariancatalin.mvp.data.api.service.NewsService
import cucerdariancatalin.mvp.data.api.service.SourceService
import cucerdariancatalin.mvp.data.scheduler.SchedulerInterface
import cucerdariancatalin.mvp.data.scheduler.SchedulerProvider
import cucerdariancatalin.mvp.repository.news.NewsRepository
import cucerdariancatalin.mvp.repository.news.RemoteNewsDataSource
import cucerdariancatalin.mvp.repository.source.RemoteSourceDataSource
import cucerdariancatalin.mvp.repository.source.SourceRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule() {
    @Provides
    @Singleton
    internal fun provideRemoteSourceDataSource(sourceService:
                                               SourceService
    ): RemoteSourceDataSource {
        return RemoteSourceDataSource(sourceService)
    }

    @Provides
    @Singleton
    internal fun provideSourceRepository(remoteSourceDataSource:
                                         RemoteSourceDataSource
    ): SourceRepository {
        return SourceRepository(remoteSourceDataSource)
    }

    @Provides
    @Singleton
    internal fun provideNewsRemoteDataSource(newsService: NewsService): RemoteNewsDataSource {
        return RemoteNewsDataSource(newsService)
    }

    @Provides
    @Singleton
    internal fun provideNewsRepository(remoteNewsDataSource:
                                       RemoteNewsDataSource): NewsRepository {
        return NewsRepository(remoteNewsDataSource)
    }

    @Provides
    @Singleton
    internal fun provideScheduler(): SchedulerInterface {
        return SchedulerProvider.getInstance()
    }
}