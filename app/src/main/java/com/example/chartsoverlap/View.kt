package com.example.chartsoverlap

import android.util.Log

/*** B) View Class */
class View {
    private var containedChart = ArrayList<Chart>()
    private val MAX_CHART = 2

    /*** B) View Class- ensure only 2 charts can be added */
    fun insertChart(chart: Chart){
        if (containedChart.size < MAX_CHART){
            containedChart.add(chart)
        } else {
            // Produce a note message to let user know that chart- as view have reach it's limit of a maximum of 2 charts at a time
            Log.d("checks", "Chart not added: View already have 2 charts")
        }
    }

    /*** C) DoChartsOverlap() */
    fun doChartoverlap():Boolean{
        //Doesn't contain 2 squares
        if (containedChart.size < 2){
            return false
        }

        //line cannot have positive overlap
        if (containedChart[0].x1 == containedChart[0].x2 || containedChart[0].y1 == containedChart[0].y2 || containedChart[1].x1 == containedChart[1].x2 || containedChart[1].y1 == containedChart[0].y2 ){
            return false
        }

        // If one rectangle is on the left side of the other
        if (containedChart[0].x2 < containedChart[1].x1 || containedChart[1].x2 < containedChart[0].x1) {
            return false
        }

        // If one rectangle is above the other
        if (containedChart[0].y2 < containedChart[1].y1 || containedChart[1].y2 < containedChart[0].y1) {
            return false
        }
        return true
    }

    /*** D) GetColour(X,Y) */
    fun getColour(x: Float,y : Float) : List<Int>{
        // find out the location if it is in Chart1 & chart 2
        val inRectangle1 = if (containedChart.size == 0)false else (x > containedChart[0].x1 && x < containedChart[0].x2 && y > containedChart[0].y1 && y < containedChart[0].y2)
        val inRectangle2 = if (containedChart.size <  2)false else (x > containedChart[1].x1 && x < containedChart[1].x2 && y > containedChart[1].y1 && y < containedChart[1].y2)

        // return white colour if there is no chart in (X,Y)
        if (!inRectangle1 && !inRectangle2) {
            return listOf(255, 255, 255)
        }

        // in 1 charts
        // return the colour of the rectangle that it is in.
        if (inRectangle1 && !inRectangle2) {
            return listOf(containedChart[0].r,containedChart[0].g,containedChart[0].b)
        }

        if (!inRectangle1 && inRectangle2) {
            return listOf(containedChart[1].r,containedChart[1].g,containedChart[1].b)
        }

        // in both chart
        val red = (containedChart[0].r + containedChart[1].r )/2
        val green = (containedChart[0].g + containedChart[1].g )/2
        val blue = (containedChart[0].b + containedChart[1].b )/2
        return listOf(red, green, blue)
    }
}