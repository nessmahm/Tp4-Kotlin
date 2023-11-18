package com.example.tp4

import BusClassAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp4.busClassFeature.BusScheduleViewModel
import com.example.tp4.busClassFeature.BusScheduleViewModelFactory
import com.example.tp4.busschedule.BusScheduleApplication
import com.example.tp4.busschedule.Entites.Schedule

class MainActivity : AppCompatActivity() {
    private val busScheduleViewModel : BusScheduleViewModel by viewModels() {
        BusScheduleViewModelFactory((application as BusScheduleApplication).database.getScheduleDao()
    )}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitAdapter()
    }

    private fun InitAdapter() {
        val busClassAdapter = BusClassAdapter()
        InitList(busClassAdapter)

        val recyclerView: RecyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = busClassAdapter
    }

    private fun InitList(busClassAdapter: BusClassAdapter) {
        var list = listOf<Schedule>()
        Thread {
            list = busScheduleViewModel.fullSchedule()
            Handler(Looper.getMainLooper()).post {
                busClassAdapter.updateList(list)
            }
        }.start()
    }
}