package com.tuanhv.mvvmarch.sample.ui.splash

import android.arch.lifecycle.ViewModel
import com.tuanhv.mvvmarch.base.injection.PerActivity
import com.tuanhv.mvvmarch.base.preferences.user.UserSharedPreferences
import javax.inject.Inject

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@PerActivity
class SplashViewModel @Inject constructor(private val userSharedPreferences: UserSharedPreferences) : ViewModel() {

    fun getUserAccessToken(): String {
        return userSharedPreferences.getUserAccessToken()
    }

}
