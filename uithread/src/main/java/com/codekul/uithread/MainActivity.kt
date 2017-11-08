package com.codekul.uithread

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.stream.IntStream

class MainActivity : AppCompatActivity() {


    var hand: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hand = Handler(Looper.getMainLooper())
    }

    fun onOkay(vw: View) {
        MyTask().execute(0, 10/*params*/)
    }

    fun handlerWay() {
        Thread {
            for (i in 1..10) {
                Thread.sleep(2500)
                hand?.post { txtNm.text = """ $i """ }
            }
        }.start()
    }

    class MyTask : AsyncTask<Int/*params*/, Int/*progress*/, Boolean/*Result*/>() {

        override fun onPreExecute() {
            super.onPreExecute()
            // UI Thread
        }

        override fun doInBackground(vararg progress: Int?/*params*/): Boolean/*Result*/ {
            //Worker Thread

            return true
        }

        override fun onPostExecute(result: Boolean?/*result*/) {
            super.onPostExecute(result)

            //UI Thread
        }

        override fun onProgressUpdate(vararg values: Int?/*progress*/) {
            super.onProgressUpdate(*values)

            //UI Thread
        }
    }
}
