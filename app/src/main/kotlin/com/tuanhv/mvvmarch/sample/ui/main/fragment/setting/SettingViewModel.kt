package com.tuanhv.mvvmarch.sample.ui.main.fragment.setting

import android.arch.lifecycle.ViewModel
import com.tuanhv.mvvmarch.base.injection.PerFragment
import com.tuanhv.mvvmarch.base.preferences.user.UserSharedPreferences
import javax.inject.Inject

/**
 * Created by hoang.van.tuan on 8/20/18.
 */

@PerFragment
class SettingViewModel @Inject constructor(private val userSharedPreferences: UserSharedPreferences) : ViewModel() {

    fun releaseUserAccessToken() {
        userSharedPreferences.setUserAccessToken("")
    }

}
