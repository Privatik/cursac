package com.brsu.mendelyev.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.brsu.mendelyev.R
import com.brsu.mendelyev.adapter.StartNewActivity
import com.brsu.mendelyev.model.Cell
import com.brsu.mendelyev.model.CellElement
import com.brsu.mendelyev.parser.ListInfoParse.listInfo
import com.brsu.mendelyev.services.TableServices
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), StartNewActivity
{

    private var restartAcrivity = true

    override fun NextActivity(mCell: CellElement) {
        if (restartAcrivity) {
            try {
                val intent = Intent(this, InfoActivity::class.java)
                intent.putExtra("symbol", mCell.getSymbol())
               intent.putExtra("listElement", listInfo(mCell))

                restartAcrivity = false
                startActivity(intent)
            }catch (e:Exception)
            {
                Log.d("Error",e.message)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tableServices = TableServices()
        tableServices.createTable(content_container,this)
    }

    override fun onRestart() {
        super.onRestart()
        restartAcrivity = true
    }

}
