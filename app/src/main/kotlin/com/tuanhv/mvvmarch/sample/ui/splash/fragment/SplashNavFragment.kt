package com.tuanhv.mvvmarch.sample.ui.splash.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuanhv.mvvmarch.sample.R
import com.tuanhv.mvvmarch.sample.databinding.FragmentSplashNavBinding
import com.tuanhv.mvvmarch.base.ui.BaseFragment
import javax.inject.Inject

/**
 * Created by hoang.van.tuan on 8/20/18.
 */

class SplashNavFragment @Inject constructor() : BaseFragment() {

    private lateinit var splashNavBinding: FragmentSplashNavBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        splashNavBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash_nav, container, false)
        return splashNavBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
