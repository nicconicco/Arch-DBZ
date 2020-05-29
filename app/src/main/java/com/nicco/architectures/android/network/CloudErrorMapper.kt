package com.nicco.architectures.android.network

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class CloudErrorMapper(private val gson: Gson) {

    fun mapToDomainErrorException(throwable: Throwable?): ErrorModel {
        val errorModel: ErrorModel? = when (throwable) {

//            is HttpException -> {
//                // handle UNAUTHORIZED situation (when token expired)
//                if (throwable.code() == 401) {
//                    ErrorModel(ErrorStatus.UNAUTHORIZED)
//                } else {
//                    getHttpError(throwable.response().errorBody())
//                }
//            }

            // handle api call timeout error
            is SocketTimeoutException -> {
                ErrorModel(
                    "TIME OUT!!",
                    0,
                    ErrorStatus.TIMEOUT
                )
            }

            // handle connection error
            is IOException -> {
                ErrorModel(
                    "CHECK CONNECTION",
                    0,
                    ErrorStatus.NO_CONNECTION
                )
            }

            is UnknownHostException -> {
                ErrorModel(
                    "CHECK CONNECTION",
                    0,
                    ErrorStatus.NO_CONNECTION
                )
            }
            else -> null
        }
        return errorModel!!
    }

    /**
     * attempts to parse http response body and get error data from it
     *
     * @param body retrofit response body
     * @return returns an instance of [ErrorModel] with parsed data or NOT_DEFINED status
     */
    private fun getHttpError(body: ResponseBody?): ErrorModel {
        return try {
            // use response body to get error detail
            val result = body?.string()
            Log.d("getHttpError", "getErrorMessage() called with: errorBody = [$result]")
            val json = Gson().fromJson(result, JsonObject::class.java)
            ErrorModel(
                json.toString(),
                400,
                ErrorStatus.BAD_RESPONSE
            )
        } catch (e: Throwable) {
            e.printStackTrace()
            ErrorModel(ErrorStatus.NOT_DEFINED)
        }

    }
}