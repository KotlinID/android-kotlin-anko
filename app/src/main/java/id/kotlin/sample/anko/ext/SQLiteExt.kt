package id.kotlin.sample.anko.ext

import android.content.Context
import id.kotlin.sample.anko.db.DBOpenHelper
import id.kotlin.sample.anko.db.DatabaseHelper

val Context.database: DBOpenHelper get() = DatabaseHelper.getInstance(this)