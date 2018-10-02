package com.tuanhv.mvvmarch.sample.injection

import dagger.BindsInstance
import dagger.Subcomponent
import com.tuanhv.mvvmarch.base.entity.User
import com.tuanhv.mvvmarch.base.injection.PerUser
import com.tuanhv.mvvmarch.base.repository.post.PostsRepositoryModule
import com.tuanhv.mvvmarch.sample.ui.main.MainActivityComponent

/**
 * Created by hoang.van.tuan on 2/1/18.
 */

@PerUser
@Subcomponent(
        modules = [
            (UserModule::class),
            (PostsRepositoryModule::class)
        ]
)
interface UserComponent {

    fun mainBuilder(): MainActivityComponent.Builder

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance fun user(user: User): Builder

        fun build(): UserComponent
    }

}
