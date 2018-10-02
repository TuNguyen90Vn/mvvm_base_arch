package com.tuanhv.mvvmarch.sample.ui.home

import dagger.BindsInstance
import dagger.Subcomponent
import com.tuanhv.mvvmarch.base.injection.PerActivity

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

@PerActivity
@Subcomponent(
        modules = [(HomeActivityModule::class)]
)
interface HomeActivityComponent {

    fun inject(homeActivity: HomeActivity): HomeActivity

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(homeActivity: HomeActivity): Builder

        fun build(): HomeActivityComponent

    }

}
