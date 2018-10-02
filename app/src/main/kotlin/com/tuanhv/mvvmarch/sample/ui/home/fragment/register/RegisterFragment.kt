package com.tuanhv.mvvmarch.sample.ui.home.fragment.register

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuanhv.mvvmarch.sample.R
import com.tuanhv.mvvmarch.sample.databinding.FragmentRegisterBinding
import com.tuanhv.mvvmarch.base.ui.BaseFragment
import com.tuanhv.mvvmarch.sample.ui.home.HomeActivity
import javax.inject.Inject

/**
 * Created by hoang.van.tuan on 8/20/18.
 */
class RegisterFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var homeActivity: HomeActivity

    private lateinit var registerBinding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        registerBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return registerBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        homeActivity.updateToolbar()
    }

}
