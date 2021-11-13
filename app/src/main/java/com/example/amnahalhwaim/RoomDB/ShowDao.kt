package com.example.amnahalhwaim.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.amnahalhwaim.Modle.Show

@Dao
interface ShowDao {





    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addShow(show: Show)

    @Query("SELECT * FROM ShowTable ORDER BY id ASC")
    fun getShows(): LiveData<List<Show>>

    @Update
    suspend fun updateShow(show: Show)

    @Delete
    suspend fun deleteShow(show: Show)}