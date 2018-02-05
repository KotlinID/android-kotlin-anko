package id.kotlin.sample.anko.basic.actions

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class ActionsModel(val action: String) : Parcelable