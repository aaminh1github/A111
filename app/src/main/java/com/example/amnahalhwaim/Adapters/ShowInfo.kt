package com.example.amnahalhwaim.Adapters

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.res.TypedArrayUtils.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amnahalhwaim.MainActivity
import com.example.amnahalhwaim.Modle.Show
import com.example.amnahalhwaim.R
import com.example.amnahalhwaim.Viewmodle.MainViewModel
import com.example.amnahalhwaim.databinding.ItemShowBinding
import kotlinx.android.synthetic.main.item_row.view.*
import kotlinx.android.synthetic.main.item_show.view.*
class ShowInfo(private val vModel:MainViewModel): RecyclerView.Adapter<ShowInfo.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemShowBinding) : RecyclerView.ViewHolder(binding.root)

    private lateinit var myViewModel: MainViewModel
    private lateinit var Shows: MutableList<Show>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemShowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val Show = Shows[position]

        holder.binding.apply {
            tvName.text = Show.Name
            tvLang.text = Show.language
            try {
                Glide.with(holder.itemView.context).load(Show.pic).into(imageView)
            }catch (e:Exception){
                imageView.setImageResource(R.drawable.ic_baseline_auto_awesome_24)

            }
            btDel.setOnClickListener {
                myViewModel.deleteShow(Show)
            }
        }
    }

    override fun getItemCount() = Shows.size
    fun update(newList: MutableList<Show>){
        this.Shows = newList
        notifyDataSetChanged()
    }
}
//Main.mainViewModel.deleteShow(item.id)