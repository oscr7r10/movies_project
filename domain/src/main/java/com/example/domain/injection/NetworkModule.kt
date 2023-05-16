package com.example.domain.injection

import com.example.domain.api.MoviesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val API_KEY = "3a5de749f8fcab6b8928cc0cc7fd3d19"
    const val BASE_URL = "https://api.themoviedb.org/3/movie/"

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun providesOkHttpInterceptor(): Interceptor {
        return Interceptor {chain ->
            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            chain.proceed(request)
        }
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        interceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(interceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()



    @Singleton
    @Provides
    fun provideMoviesApi(okHttpClient: OkHttpClient) : MoviesAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MoviesAPI::class.java)
    }

}