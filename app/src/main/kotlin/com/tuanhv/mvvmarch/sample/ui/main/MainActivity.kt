package com.tuanhv.mvvmarch.sample.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import com.tuanhv.mvvmarch.sample.R
import com.tuanhv.mvvmarch.sample.databinding.ActivityMainBinding
import com.tuanhv.mvvmarch.sample.platform.SampleApplication
import com.tuanhv.mvvmarch.base.platform.AppManager
import com.tuanhv.mvvmarch.base.ui.BaseActivity
import javax.inject.Inject

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    companion object {

        private const val TAG = "MainActivity"

    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appManager: AppManager

    private lateinit var mainBinding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        initiateToolbar()
    }

    override fun setupActivityComponent() {
        SampleApplication.get(this)
                .userComponent
                ?.mainBuilder()
                ?.activity(this)
                ?.build()
                ?.inject(this)
    }

    private fun initiateToolbar() {
        setSupportActionBar(mainBinding.mainToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowCustomEnabled(true)

        mainBinding.actionBackBtn.setOnClickListener {
            onBackPressed()
        }

        mainBinding.actionSettingBtn.setOnClickListener {
            Navigation.findNavController(this, R.id.nav_host_main_fragment)
                    .navigate(R.id.openSetting)
        }
    }

    fun updateToolbar() {
        val navController = Navigation.findNavController(this, R.id.nav_host_main_fragment)

        when (navController.currentDestination?.id) {
            R.id.mainNavFragment -> {
                mainBinding.mainToolbarTitle.text = getString(R.string.main_toolbar_title)
                mainBinding.actionBackBtn.visibility = View.INVISIBLE
                mainBinding.actionSettingBtn.visibility = View.VISIBLE
            }
            R.id.settingFragment -> {
                mainBinding.mainToolbarTitle.text = getString(R.string.setting_toolbar_title)
                mainBinding.actionBackBtn.visibility = View.VISIBLE
                mainBinding.actionSettingBtn.visibility = View.INVISIBLE
            }
        }
    }

    override fun onBackPressed() {
        val navController = Navigation.findNavController(this, R.id.nav_host_main_fragment)
        if (navController.currentDestination?.id != R.id.mainNavFragment) {
            navController.popBackStack()
        } else {
            if (appManager.isBackPressFinish) {
                finish()
            } else {
                Toast.makeText(this, R.string.back_pressed_finish, Toast.LENGTH_SHORT).show()
            }
        }
    }

}
