package com.brsu.mendelyev.model

import org.json.JSONObject

class CellElement(private val element:JSONObject):Cell(0) {

    public fun getName():String = element.getString("name")
    public fun getSymbol():String = element.getString("symbol")
    public fun getNumber():Int = element.getInt("number")
    public fun getAppearance():String? = element.getString("appearance")
    public fun getAtomicNass():Double = element.getDouble("atomic_mass")
    public fun getBoil():String? = element.getString("boil")
    public fun getCategory():String? = element.getString("category")
    public fun getColor():String? = element.getString("color")
    public fun getDensity():String? = element.getString("density")
    public fun getDiscoveredBy():String? = element.getString("discovered_by")
    public fun getMelt():String? = element.getString("melt")
    public fun getMolarHeat():String? = element.getString("molar_heat")
    public fun getNamedBy():String? = element.getString("named_by")
    public fun getPeriod():String? = element.getString("period")
    public fun getPhase():String? = element.getString("phase")
    public fun getElectronConfiguration():String? = element.getString("electron_configuration")
    public fun getElectronAffinity():String? = element.getString("electron_affinity")
    public fun getElectronegativityPauling():String? = element.getString("electronegativity_pauling")
    public fun getTrans():String = element.getString("info")
}