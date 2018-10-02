package com.tuanhv.mvvmarch.base.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by hoang.van.tuan on 2/1/18.
 */

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActivityComponent()
    }

    protected abstract fun setupActivityComponent()

}
