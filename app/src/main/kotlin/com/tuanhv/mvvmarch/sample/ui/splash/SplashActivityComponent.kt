package com.tuanhv.mvvmarch.sample.ui.splash

import dagger.BindsInstance
import dagger.Subcomponent
import com.tuanhv.mvvmarch.base.injection.PerActivity

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@PerActivity
@Subcomponent(
        modules = [(SplashActivityModule::class)]
)
interface SplashActivityComponent {

    fun inject(splashActivity: SplashActivity): SplashActivity

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(splashActivity: SplashActivity): Builder

        fun build(): SplashActivityComponent

    }

}
