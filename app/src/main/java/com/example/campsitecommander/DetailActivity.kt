// Student Number: ST10539394
// Full Name: Gcina Mvumvu

package com.example.campsitecommander

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private val TAG = "DetailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Log.d(TAG, "DetailActivity created")

        val names      = intent.getStringArrayListExtra("NAMES")      ?: arrayListOf()
        val categories = intent.getStringArrayListExtra("CATEGORIES") ?: arrayListOf()
        val quantities = intent.getIntegerArrayListExtra("QUANTITIES") ?: arrayListOf()
        val comments   = intent.getStringArrayListExtra("COMMENTS")   ?: arrayListOf()

        Log.d(TAG, "Received ${names.size} items to display")

        val dataList = ArrayList<HashMap<String, String>>()

        for (i in names.indices) {
            val map = HashMap<String, String>()
            map["name"]   = names[i]
            map["detail"] = "${categories[i]} - Qty: ${quantities[i]} | ${comments[i]}"
            dataList.add(map)
            Log.d(TAG, "Item $i: ${names[i]}")
        }

        val listView = findViewById<ListView>(R.id.lvGearList)
        val adapter = SimpleAdapter(
            this,
            dataList,
            android.R.layout.simple_list_item_2,
            arrayOf("name", "detail"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        listView.adapter = adapter

        val btnBack = findViewById<Button>(R.id.btnBackToBase)
        btnBack.setOnClickListener {
            Log.d(TAG, "Back to Base clicked")
            finish()
        }
    }
}
