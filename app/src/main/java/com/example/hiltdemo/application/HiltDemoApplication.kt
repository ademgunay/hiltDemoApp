package com.example.hiltdemo.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Add annotation to setup Hilt for this application
@HiltAndroidApp
class HiltDemoApplication: Application()