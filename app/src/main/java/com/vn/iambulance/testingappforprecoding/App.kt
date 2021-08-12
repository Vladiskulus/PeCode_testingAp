package com.vn.iambulance.testingappforprecoding

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 =
                NotificationChannel(CHANNEL_ID1,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH)
                    channel1.description = "This is channel 1"
            val channel2 =
                NotificationChannel(CHANNEL_ID2,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW)
                    channel1.description = "This is channel 2"
            val manager = this.getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel1)
            manager.createNotificationChannel(channel2)
        }
    }
}