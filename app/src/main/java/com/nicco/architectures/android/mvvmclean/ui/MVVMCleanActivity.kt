package com.nicco.architectures.android.mvvmclean.ui

import android.os.Bundle
import android.view.View
import com.nicco.architectures.android.R
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nicco.architectures.android.base.BaseActivity
import com.nicco.architectures.android.mvvmclean.presentation.MVVMViewModel
import com.nicco.architectures.android.mvvmclean.presentation.ViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_mvvm_clean.*

@AndroidEntryPoint
class MVVMCleanActivity : BaseActivity() {

    private val mvvmViewModel : MVVMViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_clean)

        setExtras(this)
        mvvmViewModel.findInfosMVVM()
        mvvmViewModel.viewState.observe(this, Observer {
            when (it) {
                is ViewState.showInfosMVVm -> {
                    mvvm.visibility = View.VISIBLE
                    imgMvp.visibility = View.VISIBLE
                    btnMoreInfos.visibility = View.VISIBLE
                    btnMoreInfos.text = "Para mais informacoes entre em:\n\n${it}"
                }
                is ViewState.loading -> {
                    if (it.load) progress.visibility = View.VISIBLE else progress.visibility =
                        View.GONE
                }
                is ViewState.erro -> {
                }
            }
        })
    }
}