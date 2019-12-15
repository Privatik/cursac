package com.brsu.mendelyev.parser

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader


object JSONReader {

    fun readJSON(context:Context):JSONArray
    {

        val ins = context.resources.openRawResource(context.resources.getIdentifier("periodictablejson", "raw", context.packageName))
        val rd = BufferedReader(InputStreamReader(ins))
        var line = rd.readLine()
        val response = StringBuffer()
        while (line != null) {
            response.append(line)
            response.append('\r')
            line  = rd.readLine()
        }
        rd.close()
        val jsonObject = JSONObject(response.toString())
        val jsonUrls = jsonObject.getJSONArray("elements")

        return jsonUrls

    }
}