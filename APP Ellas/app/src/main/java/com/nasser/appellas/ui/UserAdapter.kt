package com.nasser.appellas.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nasser.appellas.R
import com.nasser.appellas.data.entity.User

class UserAdapter(private val deleteUserHandler: (User) -> Unit)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var listUsers: List<User>? = null

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(user: User, deleteUserHandler: (User) -> Unit) {
            itemView.apply {
                findViewById<ImageView>(R.id.imageView2)
                findViewById<TextView>(R.id.user_text_view).text = user.username
                findViewById<Button>(R.id.action_delete).setOnClickListener {
                    deleteUserHandler(user)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val card = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)

        return UserViewHolder(card)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        listUsers?.let {
            holder.bind(it[position], deleteUserHandler)
        }
    }

    override fun getItemCount() = listUsers?.size ?: 0

    fun setData(users: List<User>) {
        listUsers = users
        notifyDataSetChanged()
    }
}