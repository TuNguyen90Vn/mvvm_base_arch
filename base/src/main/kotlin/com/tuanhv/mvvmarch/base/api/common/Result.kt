package com.tuanhv.mvvmarch.base.api.common

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

data class Result<out T>(
        val data: T?,
        val error: Throwable?
)
