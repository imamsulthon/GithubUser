package com.mamsky.accenture.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mamsky.accenture.R
import com.mamsky.accenture.data.model.UserViewParam
import com.mamsky.accenture.databinding.ItemUserBinding

class UserListAdapter(
    private var list: List<UserViewParam>
): RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            // todo
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: UserViewParam) {
            printLog("item ${item.avatarUrl}")
            with(binding) {
                tvTitle.text = item.login
                tvDesc1.text = item.url
                tvDesc2.text = item.avatarUrl
                Glide.with(binding.root.context)
                        .load(item.avatarUrl)
                        .error(R.drawable.ic_profile_user)
                        .into(imageView)
            }
        }

    }

    private fun printLog(msg: String) {
        Log.d("UserListAdapter", msg)
    }

}