package com.nicco.architectures.android.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.arch.core.util.EXTRA_TRANSITION
import com.arch.core.util.IMG_NAME
import com.arch.core.util.ViewUtil
import kotlinx.android.synthetic.main.activity_mvc.*

open class BaseActivity : AppCompatActivity() {
    //region fazendo animacao da imagem principal
    protected fun setExtras(context: Context) {
        val extras = intent.extras
        extras?.let {
            val imageTransitionName: String? =
                extras.getString(EXTRA_TRANSITION)
            firstImage.transitionName = imageTransitionName

            val img: String? = extras.getString(IMG_NAME)

            img?.let {
                firstImage.setImageDrawable(ViewUtil.getDrawableByName(context, img))
            }
        }
    }
    //endregion
}