package com.nicco.architectures.androids.myarch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nicco.architectures.androids.myarch.ui_contract.GreetingView
import com.nicco.architectures.androids.myarch.viewmodel.MyArchViewModel

/**
 * this content is from
 * https://proandroiddev.com/abstract-test-rendering-logic-of-state-in-android-7992ffe6d408
 *
 * I just copy and paste to understand the feeling of the link above to take my understanding about the theme.
 *
 * add this for understand better mokk
 * https://jivimberg.io/blog/2019/05/09/mockk-features-rundown/
 *
 */
class MyArchActivity : AppCompatActivity(), GreetingView {

    private val viewModel: MyArchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_arch)

        viewModel.viewState.observe(this, Observer {
            render(state = it)
        })
    }

    override fun showProgress(show: Boolean) {
    }

    override fun showError(error: String?) {
    }

    override fun showGreeting(greeting: String?) {
    }
}