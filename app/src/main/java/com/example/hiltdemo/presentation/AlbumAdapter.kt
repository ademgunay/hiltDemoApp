package com.example.hiltdemo.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltdemo.data.AlbumEntity
import com.example.hiltdemo.databinding.ListItemAlbumBinding

class AlbumAdapter : ListAdapter<AlbumEntity, AlbumAdapter.AlbumViewHolder>(AlbumDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.AlbumViewHolder {
        val binding = ListItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumAdapter.AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AlbumViewHolder(private val binding: ListItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(albumEntity: AlbumEntity) {
            binding.album = albumEntity
        }
    }
}

class AlbumDiffCallback : DiffUtil.ItemCallback<AlbumEntity>() {
    override fun areItemsTheSame(oldItem: AlbumEntity, newItem: AlbumEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AlbumEntity, newItem: AlbumEntity): Boolean {
        return oldItem == newItem
    }
}