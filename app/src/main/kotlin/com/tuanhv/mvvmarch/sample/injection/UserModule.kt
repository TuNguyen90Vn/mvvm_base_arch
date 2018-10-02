package com.tuanhv.mvvmarch.sample.injection

import dagger.Binds
import dagger.Module
import com.tuanhv.mvvmarch.base.entity.User

/**
 * Created by hoang.van.tuan on 2/1/18.
 */

@Module
abstract class UserModule {

    @Binds
    abstract fun bindUser(user: User): User

}
