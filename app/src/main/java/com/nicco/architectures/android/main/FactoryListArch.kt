package com.nicco.architectures.android.main

import com.nicco.architectures.android.*
import com.nicco.architectures.android.mvc.MVCModel

object Factory {

    fun createArchList(): MutableList<ListArchModelUi> = ArrayList<ListArchModelUi>().apply {
        add(
            ListArchModelUi(
                imgHeader = GOKU_ADULTO,
                img = "",
                title = "MVC",
                subtitle = "Aqui voce vera mais\ndetalhes sobre o MVC."
            )
        )
        add(
            ListArchModelUi(
                imgHeader = GOKU_SS1,
                img = "",
                title = "MVP",
                subtitle = "Aqui voce vera mais\ndetalhes sobre o MVP."
            )
        )
        add(
            ListArchModelUi(
                imgHeader = GOKU_SS2,
                img = "",
                title = "MVVM",
                subtitle = "Aqui voce vera mais\ndetalhes sobre o MVVM."
            )
        )
        add(
            ListArchModelUi(
                imgHeader = GOKU_SS3,
                img = "",
                title = "MVP Clean",
                subtitle = "Aqui voce vera mais\ndetalhes sobre o MVI."
            )
        )
        add(
            ListArchModelUi(
                imgHeader = GOKU_GOD,
                img = "",
                title = "MVVM Clean",
                subtitle = "Aqui voce vera mais\ndetalhes sobre o MVI."
            )
        )
        add(
            ListArchModelUi(
                imgHeader = GOKU_BLUE,
                img = "",
                title = "MVI",
                subtitle = "Aqui voce vera mais\ndetalhes sobre o MVI."
            )
        )
    }
}
