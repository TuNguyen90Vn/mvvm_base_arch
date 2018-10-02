package com.tuanhv.mvvmarch.base.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.tuanhv.mvvmarch.base.db.user.UserDao
import com.tuanhv.mvvmarch.base.entity.User

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

@Database(entities = [(User::class)],
        version = 1,
        exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}
