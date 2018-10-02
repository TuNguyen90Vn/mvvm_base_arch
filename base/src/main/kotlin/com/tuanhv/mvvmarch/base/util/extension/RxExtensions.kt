package com.tuanhv.mvvmarch.base.util.extension

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}
