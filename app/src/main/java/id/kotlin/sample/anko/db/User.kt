package id.kotlin.sample.anko.db

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class User(val name: String,
                val id: String,
                val age: Int,
                val occupation: String) : Parcelable