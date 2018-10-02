package com.tuanhv.mvvmarch.base.util.rx

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

@Module
class RxModule {

    @Provides
    @Singleton
    fun provideRxSchedulers(): RxSchedulers {
        return AppRxSchedulers()
    }

}

