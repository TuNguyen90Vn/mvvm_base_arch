package com.tuanhv.mvvmarch.base.api.common

import com.squareup.moshi.Json

/**
 * Created by hoang.van.tuan on 9/12/18.
 */

data class PaginatedResponse <out T>(
        @field:Json(name = "result")
        val data: List<T>?,

        @field:Json(name = "pagination")
        val pagination: Pagination?
) {
    data class Pagination(
            @field:Json(name = "after_id")
            val afterId: Long?
    )
}
