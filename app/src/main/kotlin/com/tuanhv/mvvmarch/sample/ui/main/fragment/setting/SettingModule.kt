package com.tuanhv.mvvmarch.sample.ui.main.fragment.setting

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.tuanhv.mvvmarch.base.injection.ViewModelKey

/**
 * Created by hoang.van.tuan on 8/20/18.
 */

@Module
abstract class SettingModule {

    @Binds
    @IntoMap
    @ViewModelKey(SettingViewModel::class)
    abstract fun bindSettingViewModel(settingViewModel: SettingViewModel): ViewModel

}
