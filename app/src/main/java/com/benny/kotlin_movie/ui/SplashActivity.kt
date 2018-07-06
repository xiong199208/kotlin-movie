package com.benny.kotlin_movie.ui

import android.Manifest
import android.content.Intent
import android.graphics.Typeface
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.benny.kotlin_movie.MainActivity
import com.benny.kotlin_movie.R
import com.benny.kotlin_movie.base.BaseActivity
import com.benny.kotlin_movie.base.MyApplication
import com.benny.kotlin_movie.utils.AppUtils
import com.benny.kotlin_movie.utils.MLog
import com.benny.kotlin_movie.utils.showToast
import kotlinx.android.synthetic.main.activity_splash.*
import me.weyye.hipermission.HiPermission
import me.weyye.hipermission.PermissionCallback
import me.weyye.hipermission.PermissionItem


/**
 * Created by xb on 2018/7/3.
 */

class SplashActivity : BaseActivity() {

    //设置字体
    private var textTypeface: Typeface?=null
    private var descTypeFace: Typeface?=null
    private var mAlphaAnimation: AlphaAnimation? = null
    init {
        textTypeface = Typeface.createFromAsset(MyApplication.mContext.assets, "fonts/Lobster-1.4.otf")
        descTypeFace = Typeface.createFromAsset(MyApplication.mContext.assets, "fonts/FZLanTingHeiS-L-GB-Regular.TTF")
    }

    override fun layoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        //界面渐变动画
        mAlphaAnimation = AlphaAnimation(0.3f,1.0f)
        mAlphaAnimation?.run {
            duration = 2000
            setAnimationListener(object :Animation.AnimationListener{
                override fun onAnimationRepeat(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    gotoMain()
                }

                override fun onAnimationStart(p0: Animation?) {
                }
            })
        }

        checkPermission()
    }

    private fun gotoMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun initView() {
        tv_app_name.typeface = textTypeface
        tv_splash_desc.typeface = descTypeFace
        tv_version_name.text = String.format("v%s", AppUtils.getVerName(this))

    }

    override fun start() {
    }

    /**
     * 6.0以下版本(系统自动申请) 不会弹框
     * 有些厂商修改了6.0系统申请机制，他们修改成系统自动申请权限了
     */
    private fun checkPermission(){
        val permissionItems = ArrayList<PermissionItem>()
        permissionItems.add(PermissionItem(Manifest.permission.READ_PHONE_STATE, "手机状态", R.drawable.permission_ic_phone))
        permissionItems.add(PermissionItem(Manifest.permission.WRITE_EXTERNAL_STORAGE,"存储空间", R.drawable.permission_ic_storage))
        HiPermission.create(this)
                .title("权限申请")
                .msg("为了能够正常使用，请开启以下权限")
                .permissions(permissionItems)
                .style(R.style.PermissionDefaultBlueStyle)
                .animStyle(R.style.PermissionAnimScale)
                .checkMutiPermission(object : PermissionCallback {
                    override fun onClose() {
                        MLog.e( "permission_onClose")
                        showToast("用户关闭了权限")
                    }

                    override fun onFinish() {
                        //showToast("初始化完毕！")
                        layout_splash.startAnimation(mAlphaAnimation)
                    }

                    override fun onDeny(permission: String, position: Int) {
                        MLog.e("permission_onDeny")
                    }

                    override fun onGuarantee(permission: String, position: Int) {
                        MLog.e("permission_onGuarantee")
                    }
                })
    }

}