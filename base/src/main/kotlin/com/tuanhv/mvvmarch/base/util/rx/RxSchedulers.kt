package com.tuanhv.mvvmarch.base.util.rx

import io.reactivex.Scheduler

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

interface RxSchedulers {

    fun runOnBackground(): Scheduler

    fun io(): Scheduler

    fun compute(): Scheduler

    fun androidThread(): Scheduler

    fun internet(): Scheduler

}
