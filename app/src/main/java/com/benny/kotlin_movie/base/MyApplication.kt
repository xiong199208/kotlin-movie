package com.benny.kotlin_movie.base

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * Created by xb on 2018/7/3.
 */

class MyApplication :Application(){

    companion object {
        private val TAG = "MyApplication"
        var mContext:Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

}