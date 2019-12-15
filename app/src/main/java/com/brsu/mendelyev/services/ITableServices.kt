package com.brsu.mendelyev.services

import android.content.Context
import com.evrencoskun.tableview.TableView

interface ITableServices {
    fun createTable(table: TableView,context: Context)
}