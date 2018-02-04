package id.kotlin.sample.anko.basic

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.TextView
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.dsl.SecondExtraUI
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class SecondExtraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SecondExtraUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_second_extra)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val textView = find<TextView>(R.id.tv_name)
        val name = intent.getStringExtra("NAME")
        textView.text = resources.getString(R.string.text_name, name)
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