package id.kotlin.sample.anko.coroutine

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class CoroutinesModel(val coroutine: String) : Parcelable