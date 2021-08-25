package com.test.myapplication.utils

import com.test.myapplication.model.WeatherResponse
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AppUtils {

    companion object {

        private val TAG = javaClass.simpleName
        private var date2: String = ""
        private lateinit var newDate2: Date

        fun getList(mlist: ArrayList<WeatherResponse>): ArrayList<WeatherResponse> {

            val templist: ArrayList<WeatherResponse> = ArrayList()

            try {
                val format = SimpleDateFormat("yyyy-MM-dd")
                templist.add(mlist[0])
                newDate2 = format.parse(mlist[0].dt_txt)
                date2 = format.format(newDate2)
                for (i in mlist.indices) {
                    val newDate1 = format.parse(mlist[i].dt_txt)
                    val date1 = format.format(newDate1)
                    if (date1 != date2) {
                        templist.add(mlist[i])
                        newDate2 = format.parse(mlist[i].dt_txt)
                        date2 = format.format(newDate2)
                    }
                }

                return templist
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            return templist
        }

    }

}