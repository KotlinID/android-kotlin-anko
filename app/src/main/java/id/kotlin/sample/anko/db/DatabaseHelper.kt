package id.kotlin.sample.anko.db

import android.content.Context

object DatabaseHelper {

    const val TBL_USER = "user"

    fun getInstance(context: Context) = DBOpenHelper(context)
}