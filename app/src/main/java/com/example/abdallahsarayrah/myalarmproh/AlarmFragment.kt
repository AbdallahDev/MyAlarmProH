package com.example.abdallahsarayrah.myalarmproh

import android.os.Bundle
import android.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_alarm.*
import kotlinx.android.synthetic.main.fragment_alarm.view.*

/**
 * A simple [Fragment] subclass.
 */
class AlarmFragment : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_alarm, container, false)

        view.button2.setOnClickListener {
            val setAlarm = activity as MainActivity
            setAlarm.setAlarm(timePicker.currentHour, timePicker.currentMinute)
            this.dismiss()
        }

        return view
    }

}// Required empty public constructor
