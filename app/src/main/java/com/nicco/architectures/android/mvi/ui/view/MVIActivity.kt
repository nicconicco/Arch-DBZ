package com.nicco.architectures.android.mvi.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.nicco.architectures.android.R
import com.nicco.architectures.android.base.BaseActivity
import com.nicco.architectures.android.mvi.data.datasource.MVILocaldatasource
import com.nicco.architectures.android.mvi.data.datasource.MVIRemoteDatasource
import com.nicco.architectures.android.mvi.factory.ViewModelFactory
import com.nicco.architectures.android.mvi.ui.intent.MVIIntent
import com.nicco.architectures.android.mvi.ui.viewmodel.MVIViewModel
import com.nicco.architectures.android.mvi.ui.viewstate.MVIMainState
import kotlinx.android.synthetic.main.activity_mvi.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MVIActivity : BaseActivity() {

    private lateinit var mviViewModel: MVIViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvi)

        setExtras(this)
        setupMVIViewModel()
        setupObservers()

        lifecycleScope.launch {
            mviViewModel.userIntent.send(MVIIntent.LoadMVIModel)
        }
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            mviViewModel.state.collect {
                when (it) {
                    is MVIMainState.Idle -> {

                    }
                    is MVIMainState.Loading -> {
                        if (it.load) progress.visibility = View.VISIBLE else progress.visibility =
                            View.GONE
                    }

                    is MVIMainState.LoadedMVI -> {
                        mvi.visibility = View.VISIBLE
                        imgMVI.visibility = View.VISIBLE
                        btnMoreInfos.visibility = View.VISIBLE
                        btnMoreInfos.text = "Para mais informacoes entre em:\n\n${it}"
                    }
                    is MVIMainState.Error -> {
                        Toast.makeText(this@MVIActivity, it.error, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    //todo: Modo de fazer injecão de dependencia na mao.
    private fun setupMVIViewModel() {
        mviViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                MVILocaldatasource(),
                MVIRemoteDatasource()
            )
        ).get(MVIViewModel::class.java)
    }
}