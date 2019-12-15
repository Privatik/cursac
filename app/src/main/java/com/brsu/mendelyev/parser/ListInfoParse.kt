package com.brsu.mendelyev.parser

import com.brsu.mendelyev.model.CellElement

object ListInfoParse {

    fun listInfo(mCell: CellElement):Array<String>
    {

        val list = Array(16) {""}
        list[0] = "Название \n" + chekNull(mCell.getName())
        list[14] = "Внешний вид \n" + chekNull(mCell.getAppearance())
        list[13] = "Категория \n" + chekNull(mCell.getCategory())
        list[1] = "Атомная масса \n" + mCell.getAtomicNass()
        list[6] = "Температура кипения \n" +chekNull(mCell.getBoil() + " ℃")
        list[15] = "Цвет \n" + chekNull(mCell.getColor())
        list[5] = "Плотность \n" + chekNull(mCell.getDensity() + " г/см³")
        list[8] = "Обнаружен \n" + chekNull(mCell.getDiscoveredBy())
        list[7] = "Температура плавления \n" + chekNull(mCell.getMelt() + " ℃")
        list[9] = "Молярная масса \n" + chekNull(mCell.getMolarHeat())
        list[10] = "Названный \n" + chekNull(mCell.getNamedBy())
        list[11] = "Период \n" + chekNull(mCell.getPeriod())
        list[12] = "Фаза \n" + chekNull(mCell.getPhase())
        list[2] = "Электронная конфигурация \n" + chekNull(mCell.getElectronConfiguration())
        list[4] = "Cродство к электрону \n" + chekNull(mCell.getElectronAffinity())
        list[3] = "Электроотрицательность \n" + chekNull(mCell.getElectronegativityPauling())
        return list
    }

    private fun chekNull(string:String?): String?
    {
        if (string.equals("null"))
        {
            return "-"
        }
        return string
    }
}