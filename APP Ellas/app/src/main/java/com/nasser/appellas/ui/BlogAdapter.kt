package com.nasser.appellas.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nasser.appellas.R
import com.nasser.appellas.data.entity.Blog

class BlogAdapter() : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    private var blogList: List<Blog>? = null

    class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(blog: Blog) {
            itemView.apply {
                findViewById<TextView>(R.id.tittle_text_view).text = blog.title
                findViewById<TextView>(R.id.subtittle_text_view).text = blog.subtitle
                findViewById<TextView>(R.id.description_text_view).text = blog.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val card = LayoutInflater.from(parent.context)
            .inflate(R.layout.blog_item, parent, false)

        return BlogViewHolder(card)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        blogList?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount() = blogList?.size ?: 0

    fun setData(blogs: List<Blog>) {
        blogList = blogs
        notifyDataSetChanged()
    }
}