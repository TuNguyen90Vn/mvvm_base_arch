package com.tuanhv.mvvmarch.base.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by hoang.van.tuan on 2/1/18.
 */

@Entity(tableName = "user")
data class User(
        @PrimaryKey
        val accessToken: String
)
