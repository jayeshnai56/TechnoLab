package com.lattitudetech.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lattitudetech.db.dao.DbUserDao
import com.lattitudetech.db.entity.DbUser

@Database(entities = [DbUser::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): DbUserDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "TechnoLab"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

    }
}