package id.kotlin.sample.anko.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.INTEGER
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
import org.jetbrains.anko.db.PRIMARY_KEY
import org.jetbrains.anko.db.TEXT
import org.jetbrains.anko.db.UNIQUE
import org.jetbrains.anko.db.createTable
import org.jetbrains.anko.db.dropTable

class DBOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, "user.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
                DatabaseHelper.TBL_USER,
                true,
                "id" to TEXT + PRIMARY_KEY + UNIQUE,
                "name" to TEXT,
                "age" to INTEGER,
                "occupation" to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(
                DatabaseHelper.TBL_USER,
                true
        )
    }
}