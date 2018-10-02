package com.tuanhv.mvvmarch.base.preferences

import dagger.Module
import dagger.Provides
import com.tuanhv.mvvmarch.base.injection.SourcePreferences
import com.tuanhv.mvvmarch.base.preferences.user.UserSharedPreferences
import com.tuanhv.mvvmarch.base.repository.user.UserDataSource
import javax.inject.Singleton

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@Module
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideUserSharedPreferences(@SourcePreferences userPreferencesDataSource: UserDataSource): UserSharedPreferences {
        return userPreferencesDataSource as UserSharedPreferences
    }

}
