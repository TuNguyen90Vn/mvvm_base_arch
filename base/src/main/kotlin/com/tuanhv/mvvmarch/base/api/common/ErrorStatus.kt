package com.tuanhv.mvvmarch.base.api.common

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

enum class ErrorStatus(val code: Int, val message: String) {

    COMMON(500, "Common Error"),
    TIME_OUT(501, "Timeout Error"),
    UNKNOWN_HOST(502, "Unknown host Error")

}
