package com.brsu.mendelyev.stor

import android.content.Context
import com.brsu.mendelyev.model.Cell
import com.brsu.mendelyev.model.CellElement
import com.brsu.mendelyev.model.Column
import com.brsu.mendelyev.model.Row

interface ITableStor {

    fun getListCell(context: Context):MutableList<MutableList<Cell>>
    fun getListRow():MutableList<Row>
    fun getListColumn():MutableList<Column>
}