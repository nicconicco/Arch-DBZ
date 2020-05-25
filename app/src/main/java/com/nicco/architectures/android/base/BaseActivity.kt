package com.nicco.architectures.android.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.nicco.architectures.android.ViewUtil
import com.nicco.architectures.android.main.EXTRA_TRANSITION
import com.nicco.architectures.android.main.IMG_NAME
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