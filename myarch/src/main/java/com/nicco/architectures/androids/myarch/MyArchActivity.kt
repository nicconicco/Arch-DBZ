package com.nicco.architectures.androids.myarch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.nicco.architectures.androids.myarch.ui_contract.GreetingView
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
class MyArchActivity : AppCompatActivity(), GreetingView {

    private val viewModel: MyArchViewModelImpl by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_arch)

        lifecycleScope.launch {
            viewModel.viewState.collect {
                render(it)
            }
        }
        viewModel.doSomething()
    }

    override fun showProgress(show: Boolean) {
    }

    override fun showError(error: String?) {
    }

    override fun showGreeting(greeting: String?) {
    }
}