package com.brsu.mendelyev.adapter

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.brsu.mendelyev.model.Cell
import com.brsu.mendelyev.model.CellElement
import com.evrencoskun.tableview.listener.ITableViewListener


class OnClickController(context:Context,val mCell: MutableList<MutableList<Cell>>) : ITableViewListener {

    private val clickStart:StartNewActivity = context as StartNewActivity

    override fun onCellLongPressed(p0: RecyclerView.ViewHolder, p1: Int, p2: Int) {

    }

    override fun onColumnHeaderLongPressed(p0: RecyclerView.ViewHolder, p1: Int) {

    }

    override fun onRowHeaderClicked(p0: RecyclerView.ViewHolder, p1: Int) {

    }

    override fun onColumnHeaderClicked(p0: RecyclerView.ViewHolder, p1: Int) {

    }

    override fun onCellClicked(p0: RecyclerView.ViewHolder, p1: Int, p2: Int) {
        val cell = mCell.get(p2).get(p1)
        if (cell is CellElement)
        clickStart.NextActivity(cell)
    }

    override fun onRowHeaderLongPressed(p0: RecyclerView.ViewHolder, p1: Int) {
    }
}