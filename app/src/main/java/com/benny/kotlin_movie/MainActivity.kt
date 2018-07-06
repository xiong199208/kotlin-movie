package com.benny.kotlin_movie

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.benny.kotlin_movie.base.BaseActivity
import com.benny.kotlin_movie.model.bean.TabEntity
import com.benny.kotlin_movie.ui.fragment.DiscoveryFragment
import com.benny.kotlin_movie.ui.fragment.HomeFragment
import com.benny.kotlin_movie.ui.fragment.HotFragment
import com.benny.kotlin_movie.ui.fragment.MineFragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity() {

    //默认为0
    private var mIndex = 0
    private val mTitles = arrayOf("每日精选", "发现", "热门", "我的")

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected)
    // tab列表
    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mHomeFragment: HomeFragment? = null
    private var mDiscoveryFragment: DiscoveryFragment? = null
    private var mHotFragment: HotFragment? = null
    private var mMineFragment: MineFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if(savedInstanceState!=null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)
        initTab()
        tab_layout.currentTab = mIndex
        switchFragment(mIndex)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (tab_layout != null) {
            outState?.putInt("currTabIndex", mIndex)
        }
    }

    private fun initTab() {
        (0 until mTitles.size).
                mapTo(mTabEntities) {
                    TabEntity(mTitles[it],mIconSelectIds[it],mIconUnSelectIds[it])
                }
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object :OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {
            }

        })
    }

    private fun switchFragment(position:Int) {

        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when(position) {
            0
            -> mHomeFragment?.let {
                transaction.show(it)
            }?:HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container,it)
            }
            1
            -> mDiscoveryFragment?.let {
                transaction.show(it)
            }?:DiscoveryFragment.getInstance(mTitles[position]).let {
                mDiscoveryFragment = it
                transaction.add(R.id.fl_container,it)
            }
            2
            -> mHotFragment?.let {
                transaction.show(it)
            }?:HotFragment.getInstance(mTitles[position]).let {
                mHotFragment = it
                transaction.add(R.id.fl_container,it)
            }
            3
            -> mMineFragment?.let {
                transaction.show(it)
            }?:MineFragment.getInstance(mTitles[position]).let {
                mMineFragment = it
                transaction.add(R.id.fl_container,it)
            }
        }
        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()

    }

    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mHotFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
        mDiscoveryFragment?.let { transaction.hide(it) }

    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun start() {
    }

}
