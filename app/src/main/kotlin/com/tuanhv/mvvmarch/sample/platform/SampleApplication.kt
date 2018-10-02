package com.tuanhv.mvvmarch.sample.platform

import android.content.Context
import com.facebook.stetho.Stetho
import com.tuanhv.mvvmarch.base.entity.User
import com.tuanhv.mvvmarch.base.platform.BaseApplication
import com.tuanhv.mvvmarch.sample.injection.UserComponent
import com.tuanhv.mvvmarch.base.util.DevUtils

/**
 * Created by hoang.van.tuan on 1/29/18.
 */
class SampleApplication : BaseApplication() {

    lateinit var appComponent: ApplicationComponent
        private set
    var userComponent: UserComponent? = null
        private set

    companion object {
        fun get(context: Context): SampleApplication {
            return context.applicationContext as SampleApplication
        }
    }

    override fun onCreate() {
        super.onCreate()

        initStetho()
        initAppComponent()
    }

    private fun initStetho() {
        if (!DevUtils.isRunningTests()) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun initAppComponent() {
        this.appComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build()
    }

    fun createUserComponent(user: User): UserComponent? {
        if (userComponent == null) {
            userComponent = appComponent.userBuilder()
                    .user(user)
                    .build()
        }
        return userComponent
    }

    fun releaseUserComponent() {
        userComponent = null
    }

}
