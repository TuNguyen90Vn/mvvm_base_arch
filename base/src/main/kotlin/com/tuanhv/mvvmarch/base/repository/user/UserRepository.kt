package com.tuanhv.mvvmarch.base.repository.user

import com.tuanhv.mvvmarch.base.injection.SourceLocal
import com.tuanhv.mvvmarch.base.injection.SourcePreferences
import com.tuanhv.mvvmarch.base.injection.SourceRemote
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@Singleton
class UserRepository @Inject constructor(
        @SourceRemote private val userRemoteDataSource: UserDataSource,
        @SourceLocal private val userLocalDataSource: UserDataSource,
        @SourcePreferences private val userPreferencesDataSource: UserDataSource
) : UserDataSource {

}
