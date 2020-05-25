package com.nicco.architectures.android

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

const val GOKU_CRIANCA = "GOKU_CRIANCA"
const val GOKU_ADULTO = "GOKU_ADULTO"
const val GOKU_SS1 = "GOKU_SS1"
const val GOKU_SS2 = "GOKU_SS2"
const val GOKU_SS3 = "GOKU_SS3"
const val GOKU_GOD = "GOKU_GOD"
const val GOKU_BLUE = "GOKU_BLUE"

object ViewUtil {
    fun getDrawableByName(context: Context, name: String): Drawable? {
        return when (name) {
            GOKU_CRIANCA -> {
                ContextCompat.getDrawable(context, R.drawable.ic_goku_crianca)
            }
            GOKU_ADULTO -> {
                ContextCompat.getDrawable(context, R.drawable.ic_goku_vegeta)
            }
            GOKU_SS1 -> {
                ContextCompat.getDrawable(context, R.drawable.ic_goku_ss)
            }
            GOKU_SS2 -> {
                ContextCompat.getDrawable(context, R.drawable.ic_goku_ss_dois)
            }
            GOKU_SS3 -> {
                ContextCompat.getDrawable(context, R.drawable.ic_goku_ss_tres)
            }
            GOKU_GOD -> {
                ContextCompat.getDrawable(context, R.drawable.ic_goku_god)
            }
            GOKU_BLUE -> {
                ContextCompat.getDrawable(context, R.drawable.ic_goku_blue)
            }
            else -> {
                ContextCompat.getDrawable(context, R.drawable.ic_goku_vegeta)
            }
        }
    }
}