package com.example.navcomponent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlayerModel(
    val id: Int,
    val name: String,
    val img: Int,
    val height: String,
    val age: String,
    val weight: String,
    val experience: String,
    val bio: String,
) : Parcelable

