package com.tuanhv.mvvmarch.sample.ui.home

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import com.tuanhv.mvvmarch.base.injection.PerFragment
import com.tuanhv.mvvmarch.base.injection.ViewModelKey
import com.tuanhv.mvvmarch.sample.ui.home.fragment.HomeNavFragment
import com.tuanhv.mvvmarch.sample.ui.home.fragment.login.LoginFragment
import com.tuanhv.mvvmarch.sample.ui.home.fragment.login.LoginModule
import com.tuanhv.mvvmarch.sample.ui.home.fragment.register.RegisterFragment
import com.tuanhv.mvvmarch.sample.ui.home.fragment.register.RegisterModule

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

@Module
abstract class HomeActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeNavFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun contributeLoginFragment(): LoginFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [RegisterModule::class])
    abstract fun contributeRegisterFragment(): RegisterFragment

}
