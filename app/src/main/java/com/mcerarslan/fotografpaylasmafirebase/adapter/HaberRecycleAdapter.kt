package com.mcerarslan.fotografpaylasmafirebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mcerarslan.fotografpaylasmafirebase.R
import com.mcerarslan.fotografpaylasmafirebase.model.Post
import kotlinx.android.synthetic.main.recycler_row.view.*

class HaberRecycleAdapter(val postList: ArrayList<Post> ) : RecyclerView.Adapter<HaberRecycleAdapter.PostHolder>() {

    class PostHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row,parent,false)
        return PostHolder(view)
    }
    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.itemView.recycler_row_kullanici_email.text = postList[position].kullaniciEmail
        holder.itemView.recycle_row_yorum.text = postList[position].KullaniciYorum

    }



}