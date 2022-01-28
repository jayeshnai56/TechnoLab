package com.lattitudetech.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.lattitudetech.db.entity.DbUser

@Dao
interface DbUserDao {
    @Query("SELECT * FROM DbUser")
    fun getAll(): List<DbUser>

    @Insert(onConflict = REPLACE)
    fun insert(vararg user: DbUser)

    @Query("SELECT count(*) as Count FROM DbUser")
    fun getRawCount(): Int

    @Query("DELETE FROM DbUser")
    fun clearData()
}