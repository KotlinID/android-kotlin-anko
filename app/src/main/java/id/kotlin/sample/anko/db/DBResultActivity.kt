package id.kotlin.sample.anko.db

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.TextView
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.dsl.DBResultUI
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class DBResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DBResultUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_db_result)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val textName = find<TextView>(R.id.tv_name)
        val textAge = find<TextView>(R.id.tv_age)
        val textOccupation = find<TextView>(R.id.tv_occupation)
        textName.text = resources.getString(R.string.text_name, "Budi")
        textAge.text = resources.getString(R.string.text_age, "30")
        textOccupation.text = resources.getString(R.string.text_occupation, "Programmer")
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