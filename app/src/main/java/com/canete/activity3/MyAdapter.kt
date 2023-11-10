package com.canete.activity3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val MyNameList : ArrayList<MyData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder> (){

    private lateinit var Mylistener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        Mylistener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView,Mylistener)

    }

    override fun getItemCount(): Int {
        return MyNameList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = MyNameList[position]
        holder.tittleImage.setImageResource(currentItem.titleimage)
        holder.tvHeading.text = currentItem.heading

    }
    class MyViewHolder (itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val tittleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)

        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }


        }

    }

}
