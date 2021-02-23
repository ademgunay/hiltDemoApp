package com.example.hiltdemo.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Step 4: Add annotation to your application class
@HiltAndroidApp
class HiltDemoApplication: Application()