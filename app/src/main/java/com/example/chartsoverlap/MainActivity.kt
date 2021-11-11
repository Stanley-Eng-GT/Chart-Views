package com.example.chartsoverlap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testEmpty()
        test1chart()
        test2charts()
        testAdd3chart()

    }
    private fun testEmpty(){
        val view1 = View()
        Log.d("test0", view1.doChartoverlap().toString())
        Log.d("test0", view1.getColour(20f,20f).toString())
    }

    private fun test1chart(){
        val view1 = View()
        val chartA = Chart(20f, 40f, 20f, 40f, 255, 0, 0)
        view1.insertChart(chartA)

        Log.d("test1", view1.doChartoverlap().toString())
        Log.d("test1", view1.getColour(30f,30f).toString()) // in chart
        Log.d("test1", view1.getColour(10f,10f).toString()) // not in chart

    }

    private fun test2charts(){

        val view1 = View()
        val chartA = Chart(20f, 40f, 20f, 40f, 255, 0, 0)
        view1.insertChart(chartA)
        val chartB = Chart(30f, 50f, 30f, 50f, 0, 255, 0)
        view1.insertChart(chartB)

        Log.d("test2", view1.doChartoverlap().toString())
        Log.d("test2", view1.getColour(10f,10f).toString()) // not in chart
        Log.d("test2", view1.getColour(25f,25f).toString()) // in 1 chart
        Log.d("test2", view1.getColour(35f,35f).toString()) // in both chart

    }

    private fun testAdd3chart(){
        val view1 = View()
        val chartA = Chart(20f, 40f, 20f, 40f, 255, 0, 0)
        view1.insertChart(chartA)
        val chartB = Chart(30f, 50f, 30f, 50f, 0, 255, 0)
        view1.insertChart(chartB)
        val chartC = Chart(10f, 50f, 10f, 50f, 0, 0, 255 )
        view1.insertChart(chartC)

        Log.d("test3", view1.doChartoverlap().toString())
        Log.d("test3", view1.getColour(10f,10f).toString()) // not in chart
        Log.d("test3", view1.getColour(25f,25f).toString()) // in 1 chart
        Log.d("test3", view1.getColour(35f,35f).toString()) // in both chart
    }
}