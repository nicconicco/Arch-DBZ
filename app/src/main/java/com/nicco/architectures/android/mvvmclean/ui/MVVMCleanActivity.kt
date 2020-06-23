package com.nicco.architectures.android.mvvmclean.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.nicco.architectures.android.R
import com.nicco.architectures.android.base.BaseActivity
import com.nicco.architectures.android.mvvmclean.presentation.MVVMViewModel
import com.nicco.architectures.android.mvvmclean.presentation.ViewState
import com.nicco.architectures.android.mvvmclean.presentation.exaustive
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_mvvm_clean.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MVVMCleanActivity : BaseActivity() {

    private val mvvmViewModel: MVVMViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_clean)

        setExtras(this)
        mvvmViewModel.findInfosMVVM()

        lifecycleScope.launch {
            mvvmViewModel.state.collect {
                when(it) {
                    is ViewState.SuccessInfosMVVM -> {
                        mvvm.visibility = View.VISIBLE
                        imgMvp.visibility = View.VISIBLE
                        btnMoreInfos.visibility = View.VISIBLE
                        btnMoreInfos.text = "Para mais informacoes entre em:\n\n${it.mvvm.url}"
                    }
                    is ViewState.Loading -> {
                        if (it.load) progress.visibility = View.VISIBLE else progress.visibility =
                            View.GONE
                    }
                    is ViewState.Error -> {
                    }
                    is ViewState.Idle -> {
                    }
                }
            }.exaustive
        }
    }
}