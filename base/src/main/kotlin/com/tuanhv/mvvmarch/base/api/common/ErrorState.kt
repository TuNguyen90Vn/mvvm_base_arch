package com.tuanhv.mvvmarch.base.api.common

import com.squareup.moshi.Json

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

data class ErrorState(
        @field:Json(name = "error_message")
        val errorMessage: String?,

        @field:Json(name = "error_code")
        val errorCode: Int?
)
