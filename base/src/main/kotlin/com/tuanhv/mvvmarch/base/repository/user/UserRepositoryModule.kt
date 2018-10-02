package com.tuanhv.mvvmarch.base.repository.user

import android.content.Context
import dagger.Module
import dagger.Provides
import com.tuanhv.mvvmarch.base.api.user.UserApi
import com.tuanhv.mvvmarch.base.api.user.UserRemoteDataSource
import com.tuanhv.mvvmarch.base.db.user.UserDao
import com.tuanhv.mvvmarch.base.db.user.UserLocalDataSource
import com.tuanhv.mvvmarch.base.injection.SourceLocal
import com.tuanhv.mvvmarch.base.injection.SourcePreferences
import com.tuanhv.mvvmarch.base.injection.SourceRemote
import com.tuanhv.mvvmarch.base.preferences.user.UserPreferencesDataSource
import com.tuanhv.mvvmarch.base.util.rx.RxSchedulers
import javax.inject.Singleton

/**
 * Created by hoang.van.tuan on 2/5/18.
 */

@Module
class UserRepositoryModule {

    @Singleton
    @Provides
    @SourcePreferences
    fun provideUserPreferencesDataSource(context: Context): UserDataSource {
        return UserPreferencesDataSource(context)
    }

    @Singleton
    @Provides
    @SourceLocal
    fun provideUserLocalDataSource(userDao: UserDao): UserDataSource {
        return UserLocalDataSource(userDao)
    }

    @Singleton
    @Provides
    @SourceRemote
    fun provideUserRemoteDataSource(userApi: UserApi, rxSchedulers: RxSchedulers): UserDataSource {
        return UserRemoteDataSource(userApi, rxSchedulers)
    }

}
