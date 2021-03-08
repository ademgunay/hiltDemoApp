package com.example.hiltdemo.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltdemo.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private val albumAdapter: AlbumAdapter by lazy {
        AlbumAdapter()
    }
    private val postAdapter: PostAdapter by lazy {
        PostAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainRecyclerView = findViewById<RecyclerView>(R.id.mainRecyclerView)

        mainRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter //TODO replace by postAdapter
        }

        mainViewModel.albumList.observe(this) {
            albumAdapter.submitList(it)
        }

        mainViewModel.postList.observe(this) {
            postAdapter.submitList(it)
        }

        mainViewModel.errorMsg.observe(this) { message ->
            MaterialAlertDialogBuilder(this).apply {
                setMessage(message)
                setPositiveButton("Ok") { _, _ -> } //Just dismiss
                show()
            }
        }

        mainViewModel.fetchPosts()
    }
}