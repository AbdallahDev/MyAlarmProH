package com.example.abdallahsarayrah.myalarmproh

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.FragmentManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.getStringExtra("fragment") == "AlarmFragment") {
            val alertFragment = AlarmFragment()
            alertFragment.show(fragmentManager, "alarm")
        }

        button.setOnClickListener {
            val alarmFragment = AlarmFragment()
            alarmFragment.show(fragmentManager, "alarm")
        }
    }

    @SuppressLint("SetTextI18n")
    fun setAlarm(currentHour: Int, currentMinute: Int) {
        textView.text = currentHour.toString() + ":$currentMinute"

        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, currentHour)
        cal.set(Calendar.MINUTE, currentMinute)

        val manager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, AlarmReceiver::class.java)
        intent.action = "com.example.alarm"
        val pi = PendingIntent.getBroadcast(this, 123, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        manager.setRepeating(AlarmManager.RTC_WAKEUP, cal.timeInMillis, AlarmManager.INTERVAL_DAY, pi)
    }
}
