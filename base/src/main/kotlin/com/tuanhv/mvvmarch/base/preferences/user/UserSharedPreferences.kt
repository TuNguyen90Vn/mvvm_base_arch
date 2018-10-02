package com.tuanhv.mvvmarch.base.preferences.user

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

interface UserSharedPreferences {

    fun getUserAccessToken(): String
    fun setUserAccessToken(userToken: String)

}
