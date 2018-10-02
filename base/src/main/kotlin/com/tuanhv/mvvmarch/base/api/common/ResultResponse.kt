package com.tuanhv.mvvmarch.base.api.common

import com.squareup.moshi.Json

/**
 * Created by hoang.van.tuan on 9/25/18.
 */

data class ResultResponse<out T>(

        @field:Json(name = "result")
        val data: T?

)
