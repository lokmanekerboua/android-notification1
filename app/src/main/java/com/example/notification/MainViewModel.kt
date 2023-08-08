package com.example.notification

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val notificationManager: NotificationManagerCompat,
    private val notificationBuilder: NotificationCompat.Builder
) : ViewModel() {
    @SuppressLint("MissingPermission")
    fun showSimpleNotification() {
        notificationManager.notify(1, notificationBuilder.build())
    }

    @SuppressLint("MissingPermission")
    fun updateNotification() {
        notificationBuilder.setContentText("Updated Content")
        notificationManager.notify(
            1,
            notificationBuilder.setContentText("this is the message from the update").build()
        )

    }

    fun cancelNotification() {
        notificationManager.cancel(1)
    }
}