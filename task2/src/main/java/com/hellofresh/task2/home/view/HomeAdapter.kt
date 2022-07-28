package com.hellofresh.task2.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellofresh.task2.R
import com.hellofresh.task2.home.model.RecipeModel
import kotlinx.android.synthetic.main.home_rv_item_view.view.*
import java.text.SimpleDateFormat
import java.util.*

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){
    private val TYPE_HEADER: Int = 0;
    private val TYPE_ITEM: Int = 1;
    private lateinit var data : ArrayList<RecipeModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        if(viewType == TYPE_HEADER) {
            return HomeViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.home_rv_item_header, parent, false)
            )
        } else {
            return HomeViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.home_rv_item_view, parent, false)
            )
        }
    }

    fun setData(list: ArrayList<RecipeModel>){
        val date: Date = Calendar.getInstance().time
        val dateStr: String = date.toString("dd MMM")
        data = list
        data.add(0, RecipeModel(dateStr))
        notifyDataSetChanged()
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        if(position == 0) {
            return TYPE_HEADER
        } else {
            return TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        if(position == 0) {
            holder.bindHeaderView(item)
        } else {
            holder.bindView(item)
        }
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: RecipeModel?) {
            setImage(itemView.iv_thumb, item?.thumb)
            itemView.tv_title.text = item?.name
            itemView.tv_headline.text = item?.headline
        }

        fun bindHeaderView(item: RecipeModel?) {
            itemView.tv_title.text = item?.name
        }

        private fun setImage(imageView: ImageView, imageUrl: String?) {
            imageUrl?.let {
                Glide.with(HomeActivity.getInstance())
                    .load(imageUrl)
                    .into(imageView)
            }
        }
    }

}