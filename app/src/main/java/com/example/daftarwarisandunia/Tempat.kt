package com.example.daftarwarisandunia

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class Tempat(
    val name: String,
    val negara: String,
    val description: String,
    val photo: Int
) : Parcelable
