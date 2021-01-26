package com.nicco.architectures.androids.myarch

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.lifecycleScope
import com.arch.core.util.EXTRA_TRANSITION
import com.arch.core.util.IMG_NAME
import com.arch.core.util.ViewUtil
import com.nicco.architectures.androids.myarch.ui_contract.ArchGokuView
import com.nicco.architectures.androids.myarch.viewmodel.MyArchViewModelImpl
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * this content is from
 * https://proandroiddev.com/abstract-test-rendering-logic-of-state-in-android-7992ffe6d408
 *
 * I just copy and paste to understand the feeling of the link above to take my understanding about the theme.
 *
 * add this for understand better mokk
 * https://jivimberg.io/blog/2019/05/09/mockk-features-rundown/
 *
 *
 * https://mockk.io/#spy
 *
 */
typealias Layout = R.layout

class MyArchActivity : AppCompatActivity(), ArchGokuView {

    private val viewModel: MyArchViewModelImpl by viewModels()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Layout.activity_my_arch)

        val extras = intent.extras
        extras?.let {
            val imageTransitionName: String? =
                extras.getString(EXTRA_TRANSITION)

            findViewById<AppCompatImageView>(R.id.outro).transitionName = imageTransitionName

            val img: String? = extras.getString(IMG_NAME)

            img?.let {
                findViewById<AppCompatImageView>(R.id.outro).setImageDrawable(ViewUtil.getDrawableByName(this, img))
            }
        }

        lifecycleScope.launch {
            viewModel.viewState.collect {
                render(it)
            }
        }
        viewModel.doSomething()
    }

    override fun showProgress(show: Boolean) {
        //todo: mostrar progress
    }

    override fun showError(error: String?) {
        //todo: mostrar error
    }

    override fun showGoku(greeting: String?) {
        //todo: mostrar goku OK
    }
}
