package com.tuanhv.mvvmarch.sample.ui.main

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import com.tuanhv.mvvmarch.base.injection.PerFragment
import com.tuanhv.mvvmarch.base.injection.ViewModelKey
import com.tuanhv.mvvmarch.sample.ui.main.fragment.MainNavFragment
import com.tuanhv.mvvmarch.sample.ui.main.fragment.setting.SettingFragment
import com.tuanhv.mvvmarch.sample.ui.main.fragment.setting.SettingModule

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@Module
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeMainNavFragment(): MainNavFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [SettingModule::class])
    abstract fun contributeSettingFragment(): SettingFragment

}
