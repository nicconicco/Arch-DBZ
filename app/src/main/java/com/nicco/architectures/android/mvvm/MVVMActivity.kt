package com.nicco.architectures.android.mvvm

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import com.nicco.architectures.android.R
import com.nicco.architectures.android.main.BaseActivity
import kotlinx.android.synthetic.main.activity_mvvm.*
import kotlinx.coroutines.Dispatchers

class MVVMActivity : BaseActivity() {

    private val mVVMViewModelV4 = MVVMViewModel(
        NetworkProviderImp(), Dispatchers.Main,
        Dispatchers.IO
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
        setExtras(this)

        mVVMViewModelV4.findInfosMVVM()
        mVVMViewModelV4.viewState.observe(this, Observer {
            when (it) {
                is ViewState.showInfosMVVm -> {
                    mvvm.visibility = VISIBLE
                    imgMvp.visibility = VISIBLE
                    btnMoreInfos.visibility = VISIBLE
                    btnMoreInfos.text = "Para mais informacoes entre em:\n\n${it}"
                }
                is ViewState.loading -> {
                    if (it.load) progress.visibility = VISIBLE else progress.visibility = GONE
                }
                is ViewState.erro -> {
                }
            }
        })
    }
}
