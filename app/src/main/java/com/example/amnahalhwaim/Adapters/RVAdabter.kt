package com.example.amnahalhwaim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amnahalhwaim.Modle.Show
import com.example.amnahalhwaim.RoomDB.SHowDB
import kotlinx.android.synthetic.main.item_row.view.*
import kotlinx.android.synthetic.main.item_show.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RVAdapter(private val context:Context?): RecyclerView.Adapter<RVAdapter.ItemViewHolder> () {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)




    private var showname:MutableList<Show> = mutableListOf()

    private val database by lazy { SHowDB.getInstance(context!!).ShowDao() }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val showName=showname[position]
        holder.itemView.apply {
            tvItem.text=showName.Name

            tvItem.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    database.addShow(showName)
                }
            }

        }
    }

    override fun getItemCount() = showname.size

    fun update(newList: MutableList<Show>){
        this.showname = newList
        notifyDataSetChanged()
    }
}
