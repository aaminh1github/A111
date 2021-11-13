package com.example.amnahalhwaim.Modle

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ShowTable")

data class Show (@PrimaryKey val id: Int,var Name:String, var language:String, var sammury :String,var pic:String)