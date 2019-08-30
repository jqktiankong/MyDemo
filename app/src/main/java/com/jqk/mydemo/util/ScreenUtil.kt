package com.jqk.mydemo.util

import android.content.Context

object ScreenUtil {
    /**
     * 获取屏幕密度
     * 单位：Float
     */
   fun getDensity(context: Context): Float {
        val dm = context.resources.displayMetrics

        val density = dm.density
        return density
    }

    /**
     * 获取屏幕宽度
     * 单位：Int
     */
    fun getScreenWidth(context: Context): Int {

        val dm = context.resources.displayMetrics

        val screenWidth = dm.widthPixels

        return screenWidth
    }

    /**
     * 获取屏幕高度
     * 单位：Int
     */
    fun getScreenHeight(context: Context): Int {
        val dm = context.resources.displayMetrics

        val screenHeight = dm.heightPixels

        return screenHeight
    }

    /**
     * 获取状态栏高度
     */
    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}