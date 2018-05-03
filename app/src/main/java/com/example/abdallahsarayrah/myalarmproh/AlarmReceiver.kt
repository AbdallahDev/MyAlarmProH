package com.example.abdallahsarayrah.myalarmproh

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat

/**
 * Created by abdallah.sarayrah on 12/9/2017.
 */

class AlarmReceiver : BroadcastReceiver() {
    var alarm: String = ""

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "com.example.alarm") {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("fragment", "AlarmFragment")

            val notification = NotificationCompat.Builder(context).setDefaults(Notification.DEFAULT_ALL).setContentTitle("Alarm")
                    .setContentText("Alarm set to $alarm").setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentIntent(PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT))
                    .setAutoCancel(true).build()

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(0, notification)
        }
    }
}
