package com.tuanhv.mvvmarch.sample.ui.splash

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import com.tuanhv.mvvmarch.sample.R
import com.tuanhv.mvvmarch.sample.databinding.ActivitySplashBinding
import com.tuanhv.mvvmarch.base.entity.User
import com.tuanhv.mvvmarch.sample.platform.SampleApplication
import com.tuanhv.mvvmarch.base.ui.BaseActivity
import javax.inject.Inject

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

class SplashActivity : BaseActivity(), HasSupportFragmentInjector {

    companion object {

        private const val TAG = "SplashActivity"

        private const val SPLASH_DISPLAY_LENGTH = 1000L

    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var splashBinding: ActivitySplashBinding

    private lateinit var splashViewModel: SplashViewModel

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        splashViewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)

        Handler().postDelayed({
            startSampleApplication()
        }, SPLASH_DISPLAY_LENGTH)
    }

    override fun setupActivityComponent() {
        SampleApplication.get(this)
                .appComponent
                .splashBuilder()
                .activity(this)
                .build()
                .inject(this)
    }

    private fun startSampleApplication() {
        val userAccessToken = splashViewModel.getUserAccessToken()
        val navController = Navigation.findNavController(this, R.id.nav_host_splash_fragment)
        if (userAccessToken.isNotEmpty()) {
            SampleApplication.get(this)
                    .createUserComponent(User(userAccessToken))
            navController.navigate(R.id.openMain)
        } else {
            navController.navigate(R.id.openHome)
        }
        finish()
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host_splash_fragment).navigateUp()
}
