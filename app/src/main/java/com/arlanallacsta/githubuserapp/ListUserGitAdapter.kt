package com.arlanallacsta.githubuserapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arlanallacsta.githubuserapp.databinding.ItemBarisUserBinding
import com.bumptech.glide.Glide

class ListUserGitAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserGitAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemBarisUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemBarisUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, username, photo) = listUser[position]
        Glide.with(holder.itemView.context).load(photo).circleCrop().into(holder.binding.imgGambarUser)
        holder.binding.tvNamaPengguna.text = name
        holder.binding.tvUsernamePengguna.text = username
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listUser.size

    interface OnItemClickCallback {
        fun onItemClicked(data: User)

    }

}