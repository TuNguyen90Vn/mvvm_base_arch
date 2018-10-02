package com.tuanhv.mvvmarch.sample.ui.main.fragment.setting

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.tuanhv.mvvmarch.sample.R
import com.tuanhv.mvvmarch.sample.databinding.FragmentSettingBinding
import com.tuanhv.mvvmarch.sample.platform.SampleApplication
import com.tuanhv.mvvmarch.base.ui.BaseFragment
import com.tuanhv.mvvmarch.sample.ui.main.MainActivity
import javax.inject.Inject

/**
 * Created by hoang.van.tuan on 8/20/18.
 */
class SettingFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var mainActivity: MainActivity

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var settingBinding: FragmentSettingBinding
    private lateinit var settingViewModel: SettingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        settingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        return settingBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        settingViewModel = ViewModelProviders.of(this, viewModelFactory).get(SettingViewModel::class.java)

        mainActivity.updateToolbar()

        settingBinding.logoutBtn.setOnClickListener {
            settingViewModel.releaseUserAccessToken()
            SampleApplication.get(mainActivity).releaseUserComponent()
            NavHostFragment.findNavController(this).navigate(R.id.backToHome)
            mainActivity.finish()
        }
    }

}
