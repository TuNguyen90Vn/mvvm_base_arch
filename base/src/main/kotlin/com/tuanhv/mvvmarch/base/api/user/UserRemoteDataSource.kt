package com.tuanhv.mvvmarch.base.api.user

import com.tuanhv.mvvmarch.base.repository.user.UserDataSource
import com.tuanhv.mvvmarch.base.util.rx.RxSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@Singleton
class UserRemoteDataSource @Inject constructor(
        private val userApi: UserApi,
        private val rxSchedulers: RxSchedulers
) : UserDataSource {

}
