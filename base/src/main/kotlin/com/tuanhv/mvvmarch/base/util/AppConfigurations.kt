package com.tuanhv.mvvmarch.base.util

import android.content.Context
import android.content.res.Resources
import com.tuanhv.mvvmarch.base.R
import java.net.URL

/**
 * Created by hoang.van.tuan on 8/7/18.
 */

class AppConfigurations {

    companion object {
        @JvmStatic
        fun clientId(context: Context): String {
            return context.getString(R.string.api_client_id)
        }
    }

    enum class API {
        ROOT;

        fun getURL(resource: Resources): URL {
            val protocol = resource.getString(R.string.protocol)
            val domain = resource.getString(R.string.domain)
            val rootPath = resource.getString(R.string.root_path)
            return URL(protocol, domain, rootPath)
        }
    }

}
