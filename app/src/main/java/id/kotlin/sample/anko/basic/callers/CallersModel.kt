package id.kotlin.sample.anko.basic.callers

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class CallersModel(val type: String) : Parcelable