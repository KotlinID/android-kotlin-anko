package id.kotlin.sample.anko.basic.callers.type

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.dsl.SendMessageUI
import org.jetbrains.anko.find
import org.jetbrains.anko.sendSMS
import org.jetbrains.anko.setContentView

class SendMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SendMessageUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_sms)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val editTextPhone = find<EditText>(R.id.et_phone)
        val editTextMessage = find<EditText>(R.id.et_message)
        val button = find<Button>(R.id.btn_message)
        button.setOnClickListener {
            val phonenumber = editTextPhone.text.toString()
            val message = editTextMessage.text.toString()
            when {
                phonenumber.isNotBlank() && message.isNotBlank() -> sendSMS(phonenumber, message)
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