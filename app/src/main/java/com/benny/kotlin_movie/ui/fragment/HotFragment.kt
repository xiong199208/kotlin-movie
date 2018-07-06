package com.benny.kotlin_movie.ui.fragment

import android.os.Bundle
import com.benny.kotlin_movie.R
import com.benny.kotlin_movie.base.BaseFragment

/**
 * Created by xb on 2018/7/5.
 */

class HotFragment : BaseFragment() {
    private var mTitle: String? = null

    companion object {
        fun getInstance(title:String):HotFragment{
            val fragment = HotFragment()
            val bundle = Bundle()
            fragment.let {
                it.arguments = bundle
                it.mTitle = title
            }
            return fragment
        }
    }

    override fun initView() {
    }

    override fun lazyLoad() {
    }

    override fun getLayoutId(): Int = R.layout.fragment_hot

}