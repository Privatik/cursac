package com.brsu.mendelyev.activity

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brsu.mendelyev.R
import com.brsu.mendelyev.adapter.AdapterListInfoElement
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.content_info.*

class InfoActivity : AppCompatActivity() {

    val TAG = "InfoActivityTAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        setSupportActionBar(toolbar)
    val argument = intent.extras

    title = argument.getString("symbol")

    recInfoElement.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
         try {
    recInfoElement.adapter = AdapterListInfoElement(argument.getStringArray("listElement"))
     }catch (e:Exception)
     {Log.d("Error",e.message)}
    }

}

