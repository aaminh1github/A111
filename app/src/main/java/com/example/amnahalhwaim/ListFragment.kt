package com.example.amnahalhwaim

import android.app.ProgressDialog.show
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amnahalhwaim.Modle.Show
import com.example.amnahalhwaim.R
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.Dispatcher
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL




class ListFragment : Fragment() {


    lateinit var etShow:EditText
    lateinit var btSearch: Button
    lateinit var ShowsInfo:MutableList<Show>
     lateinit var rvMain:RecyclerView

    private lateinit var adapter :RVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list, container, false)
        rvMain= view.findViewById(R.id.rvMain)
        adapter = RVAdapter(activity?.applicationContext)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(activity)
        ShowsInfo = mutableListOf()

        etShow= view.findViewById<EditText>(R.id.etShow)
        btSearch=view.findViewById<Button>(R.id.btSearch)
            btSearch.setOnClickListener {
            try{
           var key=etShow.text.toString()
                ShowsInfo.clear()

                requestAPI(key)

                adapter.update(ShowsInfo)}
        catch(e:Exception){etShow.setText(e.toString() ) }}
       /* btSearch.setOnClickListener {
            var key=etShow.text.toString()
            requestAPI(key)
            adapter.update(ShowsInfo) }*/



        return view
    }
    fun requestAPI(search:String){
        CoroutineScope(Dispatchers.IO).launch {
            var data=async {
                fechData(search)
            }.await()
            if(data.isNotEmpty())

            {


                withContext(Dispatchers.Main){
                    try {
                        var jsonarray = JSONArray(data)
                        for(i in 0 until jsonarray.length()){
                            var apiJ =jsonarray.getJSONObject(i)
                          var sho=apiJ.getJSONObject("show")
                            var id=sho.getInt("id")
                            var name=sho.getString("name")
                            var lang=sho.getString("language")
                            var summary=sho.getString("summary")
                            var image = try {
                                sho.getJSONObject("image").getString("medium")
                            }catch (e: Exception){
                                ""

                                withContext(Dispatchers.Main){
                                    Toast.makeText(requireActivity() , "oooppssss", Toast.LENGTH_SHORT).show()
                                } }
                            ShowsInfo.add(Show(id,name,lang,summary,""))

                        }
                         }catch(e:Exception){
                        Toast.makeText(requireActivity() , "oooppssss", Toast.LENGTH_SHORT).show()

                    }
                }

            }

        }
    }
    fun fechData(key:String):String{
        var response =""
        try{
            response = URL("https://api.tvmaze.com/search/shows?q=$key").readText(Charsets.UTF_8)
        }catch (e : Exception ){
            //kkl

        }
        return response
    }




}