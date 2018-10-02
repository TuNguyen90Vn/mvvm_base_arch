package com.tuanhv.mvvmarch.sample.ui.home.fragment.register

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.tuanhv.mvvmarch.base.injection.ViewModelKey
import com.tuanhv.mvvmarch.sample.ui.home.fragment.register.RegisterViewModel

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@Module
abstract class RegisterModule {

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(registerViewModel: RegisterViewModel): ViewModel

}
