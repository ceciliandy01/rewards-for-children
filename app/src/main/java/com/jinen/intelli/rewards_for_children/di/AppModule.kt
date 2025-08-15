package com.jinen.intelli.rewards_for_children.di

import android.content.Context
import androidx.room.Room
import com.jinen.intelli.rewards_for_children.data.local.AppDatabase
import com.jinen.intelli.rewards_for_children.data.local.RewardDao
import com.jinen.intelli.rewards_for_children.data.repository.RewardRepository
import com.jinen.intelli.rewards_for_children.data.repository.RewardRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "rewards_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRewardDao(appDatabase: AppDatabase): RewardDao {
        return appDatabase.rewardDao()
    }

    @Provides
    @Singleton
    fun provideRewardRepository(rewardDao: RewardDao): RewardRepository {
        return RewardRepositoryImpl(rewardDao)
    }
}
