package com.nicco.architectures.android.mvp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import com.nicco.architectures.android.R
import com.nicco.architectures.android.mvp.providers.AppSchedulerProvider
import com.arch.core.base.network.NetworkFake
import com.arch.core.domain.MVPModel
import com.nicco.architectures.android.main.BaseActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_mvp.*

class MVPActivity : BaseActivity(), Presenter.View {

    private val mPresenter: Presenter.UserAction =
        PresenterImp(
            NetworkFake(),
            AppSchedulerProvider(Schedulers.io(), AndroidSchedulers.mainThread())
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        setExtras(this)
        mPresenter.loadMvpInfos()
    }

    override fun onStart() {
        super.onStart()
        mPresenter.attach(this)
    }

    override fun onStop() {
        super.onStop()
        mPresenter.detach()
    }

    override fun showProgress(show: Boolean) = if (show) {
        progress.visibility = VISIBLE
    } else {
        progress.visibility = INVISIBLE
    }

    override fun onLoadedInfosMvp(mvpModel: MVPModel) {
        btnMoreInfos.text = "Para mais informacoes entre em:\n\n${mvpModel.url}"

        btnMoreInfos.setOnClickListener {
            val url = mvpModel.url
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        btnMoreInfos.visibility = VISIBLE
        imgMvp.visibility = VISIBLE
        mvp.visibility = VISIBLE
    }
}
