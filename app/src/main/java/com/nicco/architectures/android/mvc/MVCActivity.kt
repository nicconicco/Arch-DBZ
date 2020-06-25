package com.nicco.architectures.android.mvc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.nicco.architectures.android.R
import com.nicco.architectures.android.base.BaseActivity
import kotlinx.android.synthetic.main.activity_mvc.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MVCActivity : BaseActivity() {

    private lateinit var controller: MVCController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)
        setExtras(this)

        controller = MVCController()
    }

    override fun onResume() {
        super.onResume()
        controller.getInfos()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MVCModel?) {
        event?.apply {
            progress.visibility = GONE
            btnMoreInfos.visibility = VISIBLE
            imgMvc.visibility = VISIBLE
            mvc.visibility = VISIBLE

            btnMoreInfos.text = "Para mais informacoes entre em:\n\n${this.url}"

            btnMoreInfos.setOnClickListener {
                val url = this.url
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
        }
    }
}
