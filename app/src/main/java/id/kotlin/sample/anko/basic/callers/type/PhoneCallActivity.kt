package id.kotlin.sample.anko.basic.callers.type

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.dsl.PhoneCallUI
import org.jetbrains.anko.find
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.setContentView

class PhoneCallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PhoneCallUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_phone)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val editText = find<EditText>(R.id.et_phone)
        val button = find<Button>(R.id.btn_call)
        button.setOnClickListener {
            val phonenumber = editText.text.toString()
            when {
                phonenumber.isNotBlank() -> makeCall(phonenumber)
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