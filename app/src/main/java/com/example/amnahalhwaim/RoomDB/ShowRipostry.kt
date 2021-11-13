package com.example.amnahalhwaim.RoomDB

import androidx.lifecycle.LiveData
import com.example.amnahalhwaim.Modle.Show


class ShowRipostry (private val showDao: ShowDao) {

    val getShows: LiveData<List<Show>> = showDao.getShows()

    suspend fun addShow(show: Show){
        showDao.addShow(show)
    }


    suspend fun deleteShow(show: Show){
        showDao.deleteShow(show)
    }

}