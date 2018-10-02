package com.tuanhv.mvvmarch.base.preferences.user

import android.content.Context
import android.content.SharedPreferences
import com.tuanhv.mvvmarch.base.repository.user.UserDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

@Singleton
class UserPreferencesDataSource @Inject constructor(
        val context: Context
) : UserSharedPreferences, UserDataSource {

    private val pref: SharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    private enum class Keys {

        USER_ACCESS_TOKEN

    }

    override fun getUserAccessToken(): String = pref.getString(Keys.USER_ACCESS_TOKEN.name, "")

    override fun setUserAccessToken(userToken: String) {
        pref.edit().putString(Keys.USER_ACCESS_TOKEN.name, userToken).apply()
    }

}
