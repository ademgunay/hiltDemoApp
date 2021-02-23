package com.example.hiltdemo.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.hiltdemo.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.albumList.observe(this) {

        }

        mainViewModel.errorMsg.observe(this) { message ->
            MaterialAlertDialogBuilder(this).apply {
                setMessage(message)
                setPositiveButton("Ok") { _, _ -> } //Just dismiss
                show()
            }
        }

        mainViewModel.fetchAlbums()
    }
}