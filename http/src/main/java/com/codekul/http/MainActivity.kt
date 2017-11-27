package com.codekul.http

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.codekul.http.dto.Sample
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var q: RequestQueue? = null
    var gs: Gson? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        q = Volley.newRequestQueue(this)
    }

    fun onGet(view: View?) {

        val url = """ http://api.openweathermap.org/data/2.5/weather?q=${edNm.text}&APPID=7406c21bb1cb9f59d936a59c4e890279 """
        q?.add(
                StringRequest(url, {
                    Log.i("@codekul", """ $it """)
                    val sm = gs?.fromJson<Sample>(it, Sample::class.java)
                    txtInf.text = """ ${sm?.main?.temp} """
                }, {})
        )
    }
}
