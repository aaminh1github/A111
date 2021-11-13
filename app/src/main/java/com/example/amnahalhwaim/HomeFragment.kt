package com.example.amnahalhwaim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.amnahalhwaim.R
import kotlinx.coroutines.*
import org.json.JSONArray
import java.net.URL


class HomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)


       view.findViewById<Button>(R.id.btList).setOnClickListener{
           Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_listFragment)
       }
        view.findViewById<Button>(R.id.btLoc).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_infoFragment)
        }
    return view}

}