package ar.com.thecoininspector.coininspector.di

import ar.com.thecoininspector.coininspector.domain.remote.CoinRepository
import ar.com.thecoininspector.coininspector.domain.remote.CoinRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun bindCoinRepoImpl(repoImpl : CoinRepositoryImpl) : CoinRepository

}