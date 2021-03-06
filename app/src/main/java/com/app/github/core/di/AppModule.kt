package com.app.github.core.di

import android.app.Application
import androidx.room.Room
import com.app.github.BuildConfig
import com.app.github.core.helper.Constants
import com.app.github.core.persistence.AppDatabase
import com.app.github.core.persistence.dao.BookmarkDao
import com.app.github.core.repository.IGithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): IGithubService =
        Retrofit.Builder()
            .client(OkHttpClient.Builder().also { client ->
                if (BuildConfig.DEBUG) {
                    val loggia = HttpLoggingInterceptor()
                    loggia.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(loggia)
                }

            }.build())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IGithubService::class.java)



    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
    ): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "github.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonDao(appDatabase: AppDatabase): BookmarkDao {
        return appDatabase.wordDao()
    }
}