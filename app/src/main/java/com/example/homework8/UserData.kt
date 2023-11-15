package com.example.homework8

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val id: Int,
    var firstName: String,
    var lastName: String,
    var email: String
) : Parcelable