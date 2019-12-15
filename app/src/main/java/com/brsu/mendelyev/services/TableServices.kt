package com.brsu.mendelyev.services

import android.content.Context
import com.brsu.mendelyev.adapter.AdapterTable
import com.brsu.mendelyev.adapter.OnClickController
import com.brsu.mendelyev.stor.TableStor
import com.evrencoskun.tableview.TableView

class TableServices: ITableServices {
    override fun createTable(table: TableView, context: Context) {
        val tableStor = TableStor()

        val adapter = AdapterTable(context)
        table.adapter = adapter
        val mCell = tableStor.getListCell(context)
        adapter.setAllItems(tableStor.getListColumn(),tableStor.getListRow(),mCell)

       table.tableViewListener = OnClickController(context, mCell)
    }
}