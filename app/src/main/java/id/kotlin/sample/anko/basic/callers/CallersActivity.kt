package id.kotlin.sample.anko.basic.callers

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.basic.callers.CallersAdapter.CallersListener
import id.kotlin.sample.anko.basic.callers.type.OpenBrowserActivity
import id.kotlin.sample.anko.basic.callers.type.PhoneCallActivity
import id.kotlin.sample.anko.basic.callers.type.SendEmailActivity
import id.kotlin.sample.anko.basic.callers.type.SendMessageActivity
import id.kotlin.sample.anko.basic.callers.type.ShareActivity
import id.kotlin.sample.anko.dsl.CallersUI
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class CallersActivity : AppCompatActivity(), CallersListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CallersUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_callers)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val recyclerView = find<RecyclerView>(R.id.rv_callers)
        val layoutManager = LinearLayoutManager(this)
        val models: MutableList<CallersModel> = arrayListOf()
        resources.getStringArray(R.array.types).map {
            val model = CallersModel(it)
            models.add(model)
        }

        val adapter = CallersAdapter(this, models.toList())
        recyclerView.layoutManager = layoutManager
        recyclerView.smoothScrollToPosition(recyclerView.bottom)
        recyclerView.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onTypeClick(position: Int) {
        when (position) {
            CallersConfigs.TYPE_CALL -> startActivity<PhoneCallActivity>()
            CallersConfigs.TYPE_SMS -> startActivity<SendMessageActivity>()
            CallersConfigs.TYPE_BROWSE -> startActivity<OpenBrowserActivity>()
            CallersConfigs.TYPE_SHARE -> startActivity<ShareActivity>()
            CallersConfigs.TYPE_EMAIL -> startActivity<SendEmailActivity>()
        }
    }
}