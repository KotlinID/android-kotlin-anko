package id.kotlin.sample.anko.basic.callers.type

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.dsl.SendEmailUI
import org.jetbrains.anko.email
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class SendEmailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SendEmailUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_email)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val editTextEmail = find<EditText>(R.id.et_email)
        val editTextSubject = find<EditText>(R.id.et_subject)
        val editTextMessage = find<EditText>(R.id.et_message)
        val button = find<Button>(R.id.btn_email)
        button.setOnClickListener {
            val emailaddress = editTextEmail.text.toString()
            val subject = editTextSubject.text.toString()
            val message = editTextMessage.text.toString()
            when {
                emailaddress.isNotBlank() && subject.isNotBlank() && message.isNotBlank() -> email(emailaddress, subject, message)
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