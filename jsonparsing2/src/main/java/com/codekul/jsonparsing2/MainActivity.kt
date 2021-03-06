package com.codekul.jsonparsing2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.codekul.jsonparsing2.dto.Sample
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gson()
    }

    fun gson() {
        val ist: InputStream = assets.open("my.json")
        val flDt = ist.bufferedReader().use {
            it.readText()
        }

        val gs = Gson()
        val sample = gs.fromJson<Sample>(flDt, Sample::class.java )
        Log.i("@codekul", """ Name - ${sample.nm} """)
        Log.i("@codekul", """ Age - ${sample.age} """)
        sample.mobs.forEach {
            Log.i("@codekul", """ $it """)
        }
    }
    fun normal() {
        val ist: InputStream = assets.open("my.json")
        val flDt = ist.bufferedReader().use {
            it.readText()
        }

        val rtObj = JSONObject(flDt)
        Log.i("@codekul", """ Name - ${rtObj.getString("nm")} """)
        Log.i("@codekul", """ Age - ${rtObj.getInt("age")} """)
        Log.i("@codekul", """ Indian - ${rtObj.getBoolean("isIndian")} """)
        Log.i("@codekul", """ Indian - ${rtObj.getDouble("sal")} """)

        val inrObj = rtObj.getJSONObject("grp")
        Log.i("@codekul", """ Title - ${inrObj.getString("ttl")} """)

        val mobs = rtObj.getJSONArray("mobs")
        mobs.iterator().forEach {
            Log.i("@codekul", """ $it """)
        }
    }
    private operator fun JSONArray.iterator(): Iterator<String>
            = (0 until length()).asSequence().map { get(it) as String }.iterator()
}
