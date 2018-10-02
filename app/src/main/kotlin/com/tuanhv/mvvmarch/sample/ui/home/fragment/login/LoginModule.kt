package com.tuanhv.mvvmarch.sample.ui.home.fragment.login

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.tuanhv.mvvmarch.base.injection.ViewModelKey

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@Module
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

}
