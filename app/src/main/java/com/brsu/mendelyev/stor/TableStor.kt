package com.brsu.mendelyev.stor

import android.content.Context
import com.brsu.mendelyev.parser.JSONReader
import com.brsu.mendelyev.model.*

class TableStor: ITableStor {

    override fun getListCell(context: Context): MutableList<MutableList<Cell>> {
        val list: MutableList<MutableList<Cell>> = mutableListOf()
        val arrayJSON = JSONReader.readJSON(context)
        for (i in 0..9)
        {
            val mul:MutableList<Cell> = mutableListOf()
            for (j in 0..17)
            {
                val objectJSON = arrayJSON.getJSONObject(i*18+j)
                mul.add(when (objectJSON.getString("name"))
                     {
                        "empty" -> CellEmpty()
                        "trans" -> CellEmpty()
                         else -> CellElement(objectJSON)
                     })
            }
            list.add(mul)
        }
        return list
    }

    override fun getListRow(): MutableList<Row> {
        val list:MutableList<Row> = mutableListOf()
        for (i in 1..10)
            if (i <= 8) list.add(Row(i.toString()))
            else list.add(Row(""))
        return list
    }

    override fun getListColumn(): MutableList<Column> {
        val list:MutableList<Column> = mutableListOf()
        for (i in 1..18)
            list.add(Column(i.toString()))
        return list
    }
}