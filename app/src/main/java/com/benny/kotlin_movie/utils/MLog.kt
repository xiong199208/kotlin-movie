package com.benny.kotlin_movie.utils

import android.util.Log

/**
 * Created by xb on 2018/7/4.
 */

/**
 * 开发阶段将下面LOG_LEVEL 设置为6这样所有的log都能显示，
 * 在发布的时候我们将LOG_LEVEL 设置为0.这样log就非常方便管理了
 */
class MLog private constructor() {

    init {
        throw Error("Do not need instantiate!")
    }

    companion object {
        var LOG_LEVEL = 6
        var ERROR = 1
        var WARN = 2
        var INFO = 3
        var DEBUG = 4
        var VERBOS = 5

        fun e(tag: String, msg: String) {
            if (LOG_LEVEL > ERROR)
                Log.e(tag, msg)
        }

        fun w(tag: String, msg: String) {
            if (LOG_LEVEL > WARN)
                Log.w(tag, msg)
        }

        fun i(tag: String, msg: String) {
            if (LOG_LEVEL > INFO)
                Log.i(tag, msg)
        }

        fun d(tag: String, msg: String) {
            if (LOG_LEVEL > DEBUG)
                Log.d(tag, msg)
        }

        fun v(tag: String, msg: String) {
            if (LOG_LEVEL > VERBOS)
                Log.v(tag, msg)
        }

        fun e(msg: String) {
            if (LOG_LEVEL > ERROR)
                Log.e("benny", msg)
        }

        fun w(msg: String) {
            if (LOG_LEVEL > WARN)
                Log.w("benny", msg)
        }

        fun i(msg: String) {
            if (LOG_LEVEL > INFO)
                Log.i("benny", msg)
        }

        fun d(msg: String) {
            if (LOG_LEVEL > DEBUG)
                Log.d("benny", msg)
        }

        fun v(msg: String) {
            if (LOG_LEVEL > VERBOS)
                Log.v("benny", msg)
        }
    }
}