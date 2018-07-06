package com.benny.kotlin_movie.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast
import com.benny.kotlin_movie.base.MyApplication


/**
 * Created by xb on 2018/7/4.
 */

fun Fragment.showToast(content: String): Toast {
    val toast = Toast.makeText(this.activity?.applicationContext, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}

fun Context.showToast(content: String): Toast {
    val toast = Toast.makeText(MyApplication.mContext, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}