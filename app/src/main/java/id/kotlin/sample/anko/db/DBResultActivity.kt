package id.kotlin.sample.anko.db

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.TextView
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.R.id
import id.kotlin.sample.anko.dsl.DBResultUI
import id.kotlin.sample.anko.ext.database
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.parseSingle
import org.jetbrains.anko.db.select
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class DBResultActivity : AppCompatActivity() {

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DBResultUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_db_result)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val textName = find<TextView>(id.tv_name)
        val textAge = find<TextView>(id.tv_age)
        val textOccupation = find<TextView>(id.tv_occupation)
        async(UI) {
            bg {
                database.use {
                    select(DatabaseHelper.TBL_USER).exec {
                        parseSingle(object : MapRowParser<User> {
                            override fun parseRow(columns: Map<String, Any?>): User {
                                val name = columns.getValue("name").toString()
                                val id = columns.getValue("id").toString()
                                val age = columns.getValue("age").toString().toInt()
                                val occupation = columns.getValue("occupation").toString()
                                user = User(name, id, age, occupation)

                                return user ?: throw Exception("User not found!")
                            }
                        })
                    }
                }
            }.await()
            textName.text = resources.getString(R.string.text_name, user?.name)
            textAge.text = resources.getString(R.string.text_age, user?.age.toString())
            textOccupation.text = resources.getString(R.string.text_occupation, user?.occupation)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}