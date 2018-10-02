package com.tuanhv.mvvmarch.sample.ui.splash

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import com.tuanhv.mvvmarch.base.injection.ViewModelKey
import com.tuanhv.mvvmarch.sample.ui.splash.fragment.SplashNavFragment

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@Module
abstract class SplashActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashNavFragment

}
