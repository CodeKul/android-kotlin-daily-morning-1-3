package com.codekul.http

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.codekul.http.dto.Sample
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.progressDialog
import org.jetbrains.anko.toast
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var q: RequestQueue? = null
    var gs: Gson? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        q = Volley.newRequestQueue(this)
        gs = Gson()
    }

    fun onGet(view: View?) {

        val pd = indeterminateProgressDialog(
                message = "Weather",
                title = """ fetching temperature for ${edNm.text}"""
        )

        val url = """ http://api.openweathermap.org/data/2.5/weather?q=${edNm.text}&APPID=7406c21bb1cb9f59d936a59c4e890279 """
        q?.add(
                StringRequest(url, {
                    Log.i("@codekul", """ $it """)
                    val sm = gs?.fromJson<Sample>(it, Sample::class.java)
                    txtInf.text = """ ${sm?.main?.temp} """

                    postData(it)

                    pd.dismiss()
                }, {
                    pd.dismiss()
                })
        )
    }

    private fun postData(dt : String) {
        val obj = JSONObject()
        obj.put("json",dt)

        val url = "https://digital-shelter-153912.firebaseio.com/helloWeather.json"
        q?.add(
                JsonObjectRequest(
                        url, obj, {
                    toast("Post Success")
                },{
                    toast("Post Error")
                })
        )
    }
}
