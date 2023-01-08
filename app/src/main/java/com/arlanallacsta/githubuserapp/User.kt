package com.arlanallacsta.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String,
    var username: String,
    var photo: Int,
    var company: String,
    var location: String,
    var repository: String,
    var followes: String,
    var following: String
) : Parcelable
