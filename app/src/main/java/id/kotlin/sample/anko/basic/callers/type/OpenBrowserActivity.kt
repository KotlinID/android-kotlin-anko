package id.kotlin.sample.anko.basic.callers.type

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.dsl.OpenBrowserUI
import org.jetbrains.anko.browse
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class OpenBrowserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OpenBrowserUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_browse)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val editText = find<EditText>(R.id.et_link)
        val button = find<Button>(R.id.btn_open)
        button.setOnClickListener {
            val link = editText.text.toString()
            when {
                link.isNotBlank() -> browse("http://$link")
            }
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