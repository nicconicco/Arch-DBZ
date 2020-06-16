package com.nicco.architectures.android.mvpclean.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import com.nicco.architectures.android.R
import com.nicco.architectures.android.base.BaseActivity
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvpclean.presentation.MVPCleanPresentation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_mvp_clean.*
import javax.inject.Inject

@AndroidEntryPoint
class MVPCleanActivity : BaseActivity(), MVPCleanPresentation.View {

    @Inject
    lateinit var mVPCleanPresentationImp: MVPCleanPresentation.Action

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