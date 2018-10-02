package com.tuanhv.mvvmarch.base.db.user

import com.tuanhv.mvvmarch.base.repository.user.UserDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@Singleton
class UserLocalDataSource @Inject constructor(private val userDao: UserDao) : UserDataSource {

}
