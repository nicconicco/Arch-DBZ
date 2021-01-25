package com.nicco.architectures.android.update_mvvm.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.nicco.architectures.android.R
import com.nicco.architectures.android.main.BaseActivity
import com.nicco.architectures.android.mvvmclean.presentation.exaustive
import com.nicco.architectures.android.update_mvvm.di.mvvmUpdateModule
import com.nicco.architectures.android.update_mvvm.presentation.MvvmUpdateViewModel
import com.nicco.architectures.android.update_mvvm.presentation.UpdateAction
import kotlinx.android.synthetic.main.activity_mvvm_update.btnMoreInfos
import kotlinx.android.synthetic.main.activity_mvvm_update.imgMvp
import kotlinx.android.synthetic.main.activity_mvvm_update.mvvm
import kotlinx.android.synthetic.main.activity_mvvm_update.progress
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

@ExperimentalCoroutinesApi
class MVVMUpdateActivity : BaseActivity() {
    private val viewModelUpdate: MvvmUpdateViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_update)

        loadModules()
        setExtras(this)

        /**
         * With Livedata
         */
//        viewModelUpdate.state.observe(this, Observer {
//            when (it) {
//                is UpdateAction.Success -> {
//                    progress.visibility = View.GONE
//                    mvvm.visibility = View.VISIBLE
//                    imgMvp.visibility = View.VISIBLE
//                    btnMoreInfos.visibility = View.VISIBLE
//                    btnMoreInfos.text = "Para mais informacoes entre em:\n\n${it.url}"
//                }
//
//                is UpdateAction.HideLoading -> {
//                    progress.visibility = View.GONE
//                }
//
//                is UpdateAction.ShowLoading -> {
//                    progress.visibility = View.VISIBLE
//                }
//
//                is UpdateAction.Error -> {
//                }
//
//                is UpdateAction.Idle -> {
//                }
//            }.exaustive
//        })

        /**
         * With Flow
         */
        lifecycleScope.launch {
            viewModelUpdate.stateFlow.collect {
                when(it) {
                    is UpdateAction.Success -> {
                        progress.visibility = View.GONE
                        mvvm.visibility = View.VISIBLE
                        imgMvp.visibility = View.VISIBLE
                        btnMoreInfos.visibility = View.VISIBLE
                        btnMoreInfos.text = "Para mais informacoes entre em:\n\n${it.url}"
                    }

                    is UpdateAction.HideLoading -> {
                        progress.visibility = View.GONE
                    }

                    is UpdateAction.ShowLoading -> {
                        progress.visibility = View.VISIBLE
                    }

                    is UpdateAction.Error -> {
                    }

                    is UpdateAction.Idle -> {
                    }
                }
            }.exaustive
        }
        /**
         * With Livedata
         */
//        viewModelUpdate.getMvvmUpdate()

        /**
         * With Flow
         */
        viewModelUpdate.getMvvmUpdateFlow()
    }

    private fun loadModules() {
        unloadModules()
        loadKoinModules(
            listOf(
                mvvmUpdateModule
            )
        )
    }

    private fun unloadModules() {
        unloadKoinModules(
            listOf(
                mvvmUpdateModule
            )
        )
    }
}