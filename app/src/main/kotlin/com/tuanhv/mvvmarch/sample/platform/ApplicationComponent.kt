package com.tuanhv.mvvmarch.sample.platform

import dagger.BindsInstance
import dagger.Component
import com.tuanhv.mvvmarch.base.api.ApiModule
import com.tuanhv.mvvmarch.base.db.DatabaseModule
import com.tuanhv.mvvmarch.sample.injection.UserComponent
import com.tuanhv.mvvmarch.base.preferences.SharedPreferencesModule
import com.tuanhv.mvvmarch.base.repository.user.UserRepositoryModule
import com.tuanhv.mvvmarch.sample.ui.home.HomeActivityComponent
import com.tuanhv.mvvmarch.sample.ui.splash.SplashActivityComponent
import com.tuanhv.mvvmarch.base.util.rx.RxModule
import javax.inject.Singleton

/**
 * Created by hoang.van.tuan on 2/1/18.
 */

@Singleton
@Component(
        modules = [
            (ApplicationModule::class),
            (RxModule::class),
            (ApiModule::class),
            (DatabaseModule::class),
            (SharedPreferencesModule::class),
            (UserRepositoryModule::class)
        ]
)
interface ApplicationComponent {

    fun splashBuilder(): SplashActivityComponent.Builder

    fun homeBuilder(): HomeActivityComponent.Builder

    fun userBuilder(): UserComponent.Builder

    @Component.Builder
    interface Builder {

        fun build(): ApplicationComponent

        @BindsInstance fun application(application: SampleApplication): Builder
    }
}
