package com.tuanhv.mvvmarch.base.api.common

import com.squareup.moshi.Moshi
import io.reactivex.observers.DisposableObserver
import com.tuanhv.mvvmarch.base.api.common.ErrorStatus.*
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by hoang.van.tuan on 2/2/18.
 */

abstract class RetrofitObserver<T> : DisposableObserver<Result<T>>() {

    /**
     * Do not override this method in derived class
     */
    final override fun onComplete() {}

    /**
     * Do not override this method in derived class, just implement [onSuccess]
     * method to handle [T] response
     */
    final override fun onNext(t: Result<T>) {
        when {
            t.data != null -> onSuccess(t.data)
            t.error != null -> handleError(t.error)
        }
    }

    /**
     * Do not override this method in derived class, just implement [onError]
     * method to handle [Error] response
     */
    final override fun onError(e: Throwable) {
        onError(ErrorState(COMMON.message, COMMON.code))
    }

    /**
     * Callback for handling Http response success (statusCode == 200)
     */
    abstract fun onSuccess(t: T)

    /**
     * Callback for handling Http response errorState (statusCode >= 400) and
     * Internet connection is not available.
     */
    abstract fun onError(error: ErrorState)

    private fun handleError(t: Throwable) {
        t.printStackTrace()
        when (t) {
            is HttpException -> {
                val errorBody: ResponseBody? = t.response().errorBody()
                val errorResponse = parseError(errorBody)
                onError(errorResponse)
            }
            is UnknownHostException -> onError(ErrorState(UNKNOWN_HOST.message, UNKNOWN_HOST.code))
            is SocketTimeoutException -> onError(ErrorState(TIME_OUT.message, TIME_OUT.code))
            else -> onError(ErrorState(COMMON.message, COMMON.code))
        }
    }

    private fun parseError(errorBody: ResponseBody?): ErrorState {
        return try {
            val strErrorBody = errorBody?.string()
            strErrorBody?.let {
                val fromJson = Moshi.Builder().build().adapter(ErrorState::class.java)
                        .fromJson(strErrorBody)
                fromJson?.errorMessage?.let { errorMessage ->
                    fromJson.errorCode?.let { errorCode ->
                        return ErrorState(errorMessage, errorCode)
                    }
                    if (!errorMessage.isBlank()) return ErrorState(errorMessage, COMMON.code)
                }
            }
            ErrorState(COMMON.message, COMMON.code)
        } catch (e: IOException) {
            e.printStackTrace()
            ErrorState(COMMON.message, COMMON.code)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            ErrorState(COMMON.message, COMMON.code)
        }
    }
}
