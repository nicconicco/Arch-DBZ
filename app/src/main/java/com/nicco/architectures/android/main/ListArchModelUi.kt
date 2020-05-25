package com.nicco.architectures.android.main

class ListArchModelUi(
    val imgHeader: String,
    val img: String,
    val title: String,
    val subtitle: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListArchModelUi

        if (imgHeader != other.imgHeader) return false
        if (img != other.img) return false
        if (title != other.title) return false
        if (subtitle != other.subtitle) return false

        return true
    }

    override fun hashCode(): Int {
        var result = imgHeader.hashCode()
        result = 31 * result + img.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + subtitle.hashCode()
        return result
    }
}