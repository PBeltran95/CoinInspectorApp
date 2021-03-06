package ar.com.thecoininspector.coininspector.di

import ar.com.thecoininspector.coininspector.application.AppConstants
import ar.com.thecoininspector.coininspector.core.WebService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    //Retrofit
    @Singleton
    @Provides
    fun providesRetrofit() = Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    @Singleton
    @Provides
    fun providesWebService(retrofit: Retrofit) = retrofit.create(WebService::class.java)
}