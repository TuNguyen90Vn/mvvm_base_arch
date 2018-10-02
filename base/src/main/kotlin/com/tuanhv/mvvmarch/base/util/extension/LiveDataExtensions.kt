package com.tuanhv.mvvmarch.base.util.extension

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import com.tuanhv.mvvmarch.base.ui.NonNullMediatorLiveData
import com.tuanhv.mvvmarch.base.ui.NonNullSingleMediatorLiveData

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

fun <T> LiveData<T>.nonNull(): NonNullMediatorLiveData<T> {
    val mediator: NonNullMediatorLiveData<T> = NonNullMediatorLiveData()
    mediator.addSource(this) { t ->
        t?.let {
            mediator.value = it
        }
    }

    return mediator
}

fun <T> NonNullMediatorLiveData<T>.observe(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, android.arch.lifecycle.Observer {
        it?.let(observer)
    })
}

fun <T> LiveData<T>.nonNullSingle(): NonNullSingleMediatorLiveData<T> {
    val mediator: NonNullSingleMediatorLiveData<T> = NonNullSingleMediatorLiveData()
    mediator.addSource(this) { t ->
        t?.let {
            mediator.value = it
        }
    }

    return mediator
}

fun <T> NonNullSingleMediatorLiveData<T>.observe(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, android.arch.lifecycle.Observer {
        it?.let(observer)
    })
}
