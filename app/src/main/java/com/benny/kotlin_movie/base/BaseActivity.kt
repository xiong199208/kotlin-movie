package com.benny.kotlin_movie.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by xb on 2018/7/2.
 */

 abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
        initData()
    }

    /**
     * 加载布局
     */
    abstract fun layoutId(): Int

    /**
     * 初始化数据
     */
    abstract  fun initData()

    /**
     * 初始化view
     */
    abstract fun initView()

    abstract fun start()

    fun openKeyBord(mEditText: EditText,mContext: Context) {
        var imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(mEditText,InputMethodManager.RESULT_SHOWN)
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
