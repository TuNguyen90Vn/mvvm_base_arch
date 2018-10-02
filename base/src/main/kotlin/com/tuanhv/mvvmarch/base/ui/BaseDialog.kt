package com.tuanhv.mvvmarch.base.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

abstract class BaseDialog : Dialog {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, themeResId: Int) : super(context, themeResId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawableResource(android.R.color.transparent)
        setCancelable(isCancelable)
        initView()
    }

    protected abstract val isCancelable: Boolean

    protected abstract fun initView()

}
