package id.kotlin.sample.anko.db

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.InputFilter
import android.view.MenuItem
import android.widget.EditText
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.dsl.DBInputUI
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class DBInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DBInputUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_db)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val editTextAge = find<EditText>(R.id.et_age)
        editTextAge.filters = arrayOf(InputFilter.LengthFilter(2))
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