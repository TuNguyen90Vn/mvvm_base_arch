package com.tuanhv.mvvmarch.base.repository.post

import dagger.Module
import dagger.Provides
import com.tuanhv.mvvmarch.base.api.post.PostsRemoteDataSource
import com.tuanhv.mvvmarch.base.db.post.PostsLocalDataSource
import com.tuanhv.mvvmarch.base.injection.PerUser
import com.tuanhv.mvvmarch.base.injection.SourceLocal
import com.tuanhv.mvvmarch.base.injection.SourceRemote

/**
 * Created by hoang.van.tuan on 2/5/18.
 */

@Module
class PostsRepositoryModule {

    @PerUser
    @Provides
    @SourceLocal
    fun providePostsLocalDataSource(): PostsDataSource {
        return PostsLocalDataSource()
    }

    @PerUser
    @Provides
    @SourceRemote
    fun providePostsRemoteDataSource(): PostsDataSource {
        return PostsRemoteDataSource()
    }

}
