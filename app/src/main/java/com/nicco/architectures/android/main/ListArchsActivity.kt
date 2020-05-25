package com.nicco.architectures.android.main

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.nicco.architectures.android.R
import com.nicco.architectures.android.mvc.MVCActivity
import com.nicco.architectures.android.mvp.MVPActivity
import kotlinx.android.synthetic.main.activity_list_archs.*

const val EXTRA_TRANSITION = "EXTRA_TRANSITION"
const val IMG_NAME = "IMG_NAME"

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
