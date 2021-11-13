package com.example.amnahalhwaim.Viewmodle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.amnahalhwaim.Modle.Show
import com.example.amnahalhwaim.RoomDB.SHowDB
import com.example.amnahalhwaim.RoomDB.ShowRipostry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ShowRipostry
    private val Show: LiveData<List<Show>>

    init {
        val dao = SHowDB.getInstance(application).ShowDao()
        repository = ShowRipostry(dao)
        Show = repository.getShows
    }

    fun getShows(): LiveData<List<Show>> {
        return Show
    }





    fun deleteShow(tvShow: Show){
        CoroutineScope(IO).launch {
            repository.deleteShow(tvShow)
        }
    }
}