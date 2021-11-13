package com.example.amnahalhwaim.RoomDB

import com.example.amnahalhwaim.Modle.Show

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
    entities = [Show::class],
    version = 1
)
abstract class SHowDB: RoomDatabase(){

    abstract fun ShowDao(): ShowDao

    companion object{
        var instance: SHowDB? = null
        fun getInstance(ctx: Context): SHowDB{
            if(instance != null)
                return instance as SHowDB
            instance = Room.databaseBuilder(ctx, SHowDB::class.java, "ShowInfo").fallbackToDestructiveMigration().build()
            return instance as SHowDB
        }
    }


}