package com.tuanhv.mvvmarch.sample.platform

import android.content.Context
import dagger.Binds
import dagger.Module
import com.tuanhv.mvvmarch.base.ui.ViewModelModule

/**
 * Created by hoang.van.tuan on 2/1/18.
 */

@Module(includes = [(ViewModelModule::class)])
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: SampleApplication): Context

}
