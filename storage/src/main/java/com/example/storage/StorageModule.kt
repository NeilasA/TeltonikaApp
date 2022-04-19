package com.example.storage

import android.app.Application
import androidx.room.Room
import com.example.usecase.BasketDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    abstract fun bindBasketDatabase(repository: RoomRepository): BasketDataSource

    companion object {

        const val DATABASE_NAME = "basket_database"

        @Provides
        @Singleton
        fun provideDatabase(app: Application) = Room.databaseBuilder(
            app, BasketDatabase::class.java, DATABASE_NAME
        ).build()

        @Provides
        @Singleton
        fun provideBasket(database: BasketDatabase) = database.basketDao()
    }
}