package com.brsu.mendelyev.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.brsu.mendelyev.R
import com.brsu.mendelyev.model.*
import com.evrencoskun.tableview.adapter.AbstractTableAdapter
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder

class AdapterTable(val context: Context) : AbstractTableAdapter<Column,Row, Cell>(context) {

    val COLOR = context.resources.getColor(R.color.colorAccent)
    val TAG = "AdapterTable"

    override fun onBindColumnHeaderViewHolder(holder: AbstractViewHolder?, columnHeaderItemModel: Any?, columnPosition: Int) {
        val column = columnHeaderItemModel as Column
        (holder as ColumnViewHolder).bind(column.getNumber())
    }

    override fun onBindRowHeaderViewHolder(holder: AbstractViewHolder?, rowHeaderItemModel: Any?, rowPosition: Int) {
        val row = rowHeaderItemModel as Row
        (holder as RowViewHolder).bind(row.getNumber())
    }

    override fun onBindCellViewHolder(holder: AbstractViewHolder?, cellItemModel: Any?, columnPosition: Int, rowPosition: Int) {

        if (holder is CellViewHolder) {
            if (cellItemModel is CellElement)
                holder.bind(
                    cellItemModel.getNumber(),
                    cellItemModel.getSymbol(),
                    cellItemModel.getName()
                )
            else if (cellItemModel is CellString)  holder.bind(cellItemModel.getTarns())
            else if (cellItemModel is CellEmpty) holder.bind("*",COLOR)
        }
    }


    override fun onCreateColumnHeaderViewHolder(parent: ViewGroup?, viewType: Int): AbstractViewHolder = ColumnViewHolder(LayoutInflater.from(context).inflate(R.layout.column_block,parent,false))
    override fun onCreateRowHeaderViewHolder(parent: ViewGroup?, viewType: Int): AbstractViewHolder = RowViewHolder(LayoutInflater.from(context).inflate(R.layout.row_block,parent,false))
    override fun onCreateCellViewHolder(parent: ViewGroup?, viewType: Int): AbstractViewHolder{
        return CellViewHolder(LayoutInflater.from(context).inflate(R.layout.cellelement_block, parent, false))
    }
    override fun onCreateCornerView(): View = LayoutInflater.from(context).inflate(R.layout.empty_block,null)


    override fun getCellItemViewType(position: Int):Int
    {
        Log.d(TAG,"CellItem $position")
        return 0
    }

    override fun getColumnHeaderItemViewType(position: Int):Int
    {
        Log.d(TAG,"Column $position")
        return 0
    }

    override fun getRowHeaderItemViewType(position: Int): Int
    {
        Log.d(TAG,"Row $position")
        return 0
    }

      class CellViewHolder(item:View):AbstractViewHolder(item)
      {
         private val number = item.findViewById<TextView>(R.id.numberElement)
         private val element = item.findViewById<TextView>(R.id.element)
         private val nameElement = item.findViewById<TextView>(R.id.nameElement)

          fun bind(number: Int, element: String, nameElement: String)
          {
              this.element.text = element
              this.number.text = number.toString()
              this.nameElement.text = nameElement
          }


          fun bind(empty:String,color:Int)
          {
              this.nameElement.text = empty
              this.element.text = empty
              this.number.text = empty
          }

          fun bind(trans:String)
          {

          }

      }

     class RowViewHolder(item:View):AbstractViewHolder(item)
      {
          private val number = item.findViewById<TextView>(R.id.numberRow)

          fun bind(number: String)
          {
              this.number.text = number
          }
      }

      class ColumnViewHolder(item:View):AbstractViewHolder(item)
      {
          private val number = item.findViewById<TextView>(R.id.numberColumn)

          fun bind(number: String)
          {
              this.number.text = number
          }
      }
}