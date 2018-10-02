package com.tuanhv.mvvmarch.base.platform

import android.annotation.SuppressLint
import android.support.multidex.MultiDexApplication

/**
 * Created by hoang.van.tuan on 8/23/18.
 * BaseApplication Debug using MultiDexApplication
 */

@SuppressLint("Registered")
open class BaseApplication : MultiDexApplication()
