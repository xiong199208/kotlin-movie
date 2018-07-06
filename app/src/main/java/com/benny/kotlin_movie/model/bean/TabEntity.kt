package com.benny.kotlin_movie.model.bean

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * Created by xb on 2018/7/5.
 */

class TabEntity(var title:String,var selectedIcon: Int,var unSelectedIcon:Int) :CustomTabEntity {
    override fun getTabUnselectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabSelectedIcon(): Int {
        return unSelectedIcon
    }

    override fun getTabTitle(): String {
        return title
    }

}
