package com.example.amnahalhwaim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amnahalhwaim.Adapters.ShowInfo
import com.example.amnahalhwaim.Modle.Show
import com.example.amnahalhwaim.R
import com.example.amnahalhwaim.Viewmodle.MainViewModel


class InfoFragment : Fragment() {

    private lateinit var ViewM: MainViewModel
    private lateinit var adapter: ShowInfo
    lateinit var shows:MutableList<Show>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
var rvMain :RecyclerView

     ViewM =ViewModelProvider(this).get(MainViewModel::class.java)
    ViewM.getShows().observe(viewLifecycleOwner, {
        Show -> adapter.update(shows)
    })

    adapter = ShowInfo(ViewM)
    rvMain.adapter = adapter
    rvMain.layoutManager = LinearLayoutManager(activity)
}
}