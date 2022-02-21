package com.mahmoudbashir.seenatask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudbashir.seenatask.R
import com.mahmoudbashir.seenatask.pojo.results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_item_layout.view.*

class PopularAdapter(val onClickI:ItemClickInterface): RecyclerView.Adapter<PopularAdapter.ViewHolder>() {


     class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    }

    private val differCallback = object : DiffUtil.ItemCallback<results>(){
        override fun areItemsTheSame(oldItem: results, newItem: results): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: results, newItem: results): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = differ.currentList[position]
        holder.itemView.apply {
            txt_title.text = result.title
            txt_published_by.text = result.source
            txt_published_date.text = result.published_date

            val imgUrl = if (differ.currentList[position].media.isNotEmpty()){
                differ.currentList[position].media[0].media_metadata[0].url
            }else{
                "R.drawable.ic_launcher_background"
            }

            Picasso.get().load(imgUrl).into(img_news)

            setOnClickListener {
                onClickI.onClick(position,imgUrl,result.title,result.abstract)
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size


    interface ItemClickInterface {
        fun onClick(position:Int,imgUrl:String,title:String,article_abstract:String)
    }
}