package com.jinen.intelli.rewards_for_children.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.jinen.intelli.rewards_for_children.data.model.Reward
import com.jinen.intelli.rewards_for_children.data.model.RewardType

@Database(entities = [Reward::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rewardDao(): RewardDao
}

class Converters {
    @TypeConverter
    fun fromRewardType(value: RewardType): String {
        return value.name
    }

    @TypeConverter
    fun toRewardType(value: String): RewardType {
        return RewardType.valueOf(value)
    }
}
