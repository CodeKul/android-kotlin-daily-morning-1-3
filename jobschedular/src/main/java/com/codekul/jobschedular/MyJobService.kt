package com.codekul.jobschedular

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyJobService : JobService() {
    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.i("@codekul", "onStopJob")
        return false
    }

    override fun onStartJob(param: JobParameters?): Boolean {

        Log.i("@codekul", """ onStartJob called """)
        return true
    }
}
