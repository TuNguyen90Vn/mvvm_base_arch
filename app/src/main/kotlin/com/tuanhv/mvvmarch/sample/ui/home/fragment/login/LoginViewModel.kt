package com.tuanhv.mvvmarch.sample.ui.home.fragment.login

import android.arch.lifecycle.ViewModel
import com.tuanhv.mvvmarch.base.injection.PerFragment
import com.tuanhv.mvvmarch.base.preferences.user.UserSharedPreferences
import javax.inject.Inject

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@PerFragment
class LoginViewModel @Inject constructor(private val userSharedPreferences: UserSharedPreferences) : ViewModel() {

    fun loginUserWithToken(userToken: String) {
        userSharedPreferences.setUserAccessToken(userToken)
    }

}
