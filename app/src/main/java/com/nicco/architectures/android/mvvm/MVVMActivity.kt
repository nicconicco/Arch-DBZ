package com.nicco.architectures.android.mvvm

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.nicco.architectures.android.R
import com.nicco.architectures.android.base.BaseActivity
import com.nicco.architectures.android.base.Status
import com.nicco.architectures.android.network.CoroutineNetworkFake
import com.nicco.architectures.android.network.NetworkFake
import kotlinx.android.synthetic.main.activity_mvvm.*
import kotlinx.coroutines.Dispatchers

class MVVMActivity : BaseActivity() {

    private val viewModel: MVVMViewModel =
        MVVMViewModel(
            CoroutineNetworkFake(
                Dispatchers.IO,
                Dispatchers.Main,
                NetworkFake()
            )
        )

    private val viewModel2: MVVMViewModelV2 = MVVMViewModelV2(NetworkFake())
    private val mVVMViewModelV3: MVVMViewModelV3 = MVVMViewModelV3(NetworkFake())
    private val mVVMViewModelV4 = MVVMViewModelV4(NetworkUseCaseImp())

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
