package id.kotlin.sample.anko.home

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class HomeModel(val menu: String) : Parcelable