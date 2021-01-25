package com.nicco.architectures.android.main

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.arch.core.util.IMG_NAME
import com.nicco.architectures.android.R
import com.nicco.architectures.android.mvc.MVCActivity
import com.nicco.architectures.android.mvi.ui.view.MVIActivity
import com.nicco.architectures.android.mvp.MVPActivity
import com.nicco.architectures.android.mvpclean.ui.MVPCleanActivity
import com.nicco.architectures.android.mvvm.MVVMActivity
import com.nicco.architectures.android.mvvmclean.ui.MVVMCleanActivity
import com.nicco.architectures.android.update_mvvm.ui.MVVMUpdateActivity
import com.nicco.architectures.androids.myarch.MyArchActivity
import kotlinx.android.synthetic.main.activity_list_archs.*

class ListArchsActivity : AppCompatActivity() {

    private val listArchAdapter by lazy {
        ListArchAdapter(object :
            Interaction {
            override fun onClickArchItem(item: ListArchModelUi, imgView: ImageView) {

                var intent = Intent(this@ListArchsActivity, MVCActivity::class.java)

                when (item.title) {
                    "MVC" -> {
                        intent = Intent(this@ListArchsActivity, MVCActivity::class.java)
                    }
                    "MVP" -> {
                        intent = Intent(this@ListArchsActivity, MVPActivity::class.java)
                    }
                    "MVVM" -> {
                        intent = Intent(this@ListArchsActivity, MVVMActivity::class.java)
                    }
                    "MVP Clean" -> {
                        intent = Intent(this@ListArchsActivity, MVPCleanActivity::class.java)
                    }
                    "MVVM Clean" -> {
                        intent = Intent(this@ListArchsActivity, MVVMCleanActivity::class.java)
                    }
                    "MVI" -> {
                        intent = Intent(this@ListArchsActivity, MVIActivity::class.java)
                    }
                    "MVVM Melhorado" -> {
                        intent = Intent(this@ListArchsActivity, MVVMUpdateActivity::class.java)
                    }
                    "TDD - States - MVVM" -> {
                        intent = Intent(this@ListArchsActivity, MyArchActivity::class.java)
                    }
                    else -> {

                    }
                }

                intent.putExtra(IMG_NAME, item.imgHeader)
                startActivity(intent)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_archs)

        listArchAdapter.submitList(Factory.createArchList())
        recycler.adapter = listArchAdapter
    }
}
