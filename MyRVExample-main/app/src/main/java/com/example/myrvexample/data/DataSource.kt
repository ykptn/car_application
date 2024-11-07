package com.example.myrvexample.data

import android.content.Context
import com.example.myrvexample.R
import com.example.myrvexample.model.Car

class DataSource(val context: Context) {
    fun getCarNameList(): Array<String>{
        return context.resources.getStringArray(R.array.name_array)
    }
    fun getCarSpecsList(): Array<String>{
        return context.resources.getStringArray(R.array.specs_array)
    }
    fun getCarPerformanceList(): Array<String>{
        return context.resources.getStringArray(R.array.performance_array)
    }

    fun loadCars(): List<Car>{
        val nameList  = getCarNameList()
        val specsList = getCarSpecsList()
        val performanceList = getCarPerformanceList()

        val cars = mutableListOf<Car>()
        for (i in nameList.indices){
            cars.add(Car(nameList[i], specs = specsList[i], performance = performanceList[i]))
        }
        return cars
    }
}