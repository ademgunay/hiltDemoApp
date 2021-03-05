package com.example.hiltdemo.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltdemo.data.PostEntity
import com.example.hiltdemo.databinding.ListItemPostBinding

class PostAdapter : ListAdapter<PostEntity, PostAdapter.PostViewHolder>(PostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        TODO("Create viewHolder for PostAdapter")
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        //TODO
    }

    inner class PostViewHolder(private val binding: ListItemPostBinding) : RecyclerView.ViewHolder(binding.root)
}

class PostDiffCallback : DiffUtil.ItemCallback<PostEntity>() {
    override fun areItemsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
        return oldItem.id == newItem.id
    }
}