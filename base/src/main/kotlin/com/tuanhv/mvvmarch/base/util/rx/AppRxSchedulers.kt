package com.tuanhv.mvvmarch.base.util.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

class AppRxSchedulers : RxSchedulers {

    companion object {

        private val backgroundExecutor: Executor = Executors.newCachedThreadPool()
        private val internetExecutor: Executor = Executors.newCachedThreadPool()

        val BACKGROUND_SCHEDULER = Schedulers.from(backgroundExecutor)
        val INTERNET_SCHEDULER = Schedulers.from(internetExecutor)

    }

    override fun runOnBackground(): Scheduler = BACKGROUND_SCHEDULER

    override fun io(): Scheduler = Schedulers.io()

    override fun compute(): Scheduler = Schedulers.computation()

    override fun androidThread(): Scheduler = AndroidSchedulers.mainThread()

    override fun internet(): Scheduler = INTERNET_SCHEDULER

}
