package id.kotlin.sample.anko.basic

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.InputFilter
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.dsl.FirstExtraUI
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class FirstExtraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirstExtraUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_first_extra)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val filter = InputFilter { source, start, end, _, _, _ ->
            for (i in start until end) {
                when {
                    !Character.isLetter(source[i]) && !Character.isSpaceChar(source[i]) -> return@InputFilter ""
                }
            }

            null
        }

        val editText = find<EditText>(R.id.et_name)
        editText.filters = arrayOf(filter)

        val button = find<Button>(R.id.btn_submit)
        button.setOnClickListener {
            val name = editText.text.toString()
            startActivity<SecondExtraActivity>("NAME" to name)
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