package com.lush_digital_.graphqlexample.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.FeedResultQuery
import com.lush_digital_.graphqlexample.R
import kotlinx.android.synthetic.main.card_view.view.*

class MyAdapter(
    myFeedResult: List<FeedResultQuery.Result?>?
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val feedResult = myFeedResult

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return feedResult?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val feedData = feedResult?.get(position)

        holder.itemView.txt_name?.text = feedData?.name
        holder.itemView.txt_gender?.text = feedData?.gender
        holder.itemView.txt_species?.text = feedData?.species

        Glide.with(holder.itemView).load(feedData?.image).into(holder.itemView.img_image)
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}