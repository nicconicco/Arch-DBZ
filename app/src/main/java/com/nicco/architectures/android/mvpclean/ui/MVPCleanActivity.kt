package com.nicco.architectures.android.mvpclean.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import com.nicco.architectures.android.R
import com.nicco.architectures.android.base.BaseActivity
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvpclean.presentation.MVPCleanPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_mvp_clean.*
import org.koin.android.ext.android.inject

class MVPCleanActivity : BaseActivity(), MVPCleanPresenter.View {

    private val mVPCleanPresentationImp: MVPCleanPresenter.Action by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp_clean)

        setExtras(this)
        mVPCleanPresentationImp.attach(this)
        mVPCleanPresentationImp.loadMvpInfos()
    }

    override fun onResume() {
        super.onResume()
        Log.d("mVPCleanPresentationImp", "${mVPCleanPresentationImp != null}")
    }

    override fun onStop() {
        super.onStop()
        mVPCleanPresentationImp.detach()
    }

    override fun showProgress(show: Boolean) = if (show) {
        progress.visibility = View.VISIBLE
    } else {
        progress.visibility = View.INVISIBLE
    }

    override fun onLoadedInfosMvp(mvpModel: MVPModel) {
        btnMoreInfos.text = "Para mais informacoes entre em:\n\n${mvpModel.url}"

        btnMoreInfos.setOnClickListener {
            val url = mvpModel.url
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        btnMoreInfos.visibility = View.VISIBLE
        imgMvp.visibility = View.VISIBLE
        mvp.visibility = View.VISIBLE
    }
}