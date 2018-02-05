package id.kotlin.sample.anko.basic.callers

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.ActivityCompat
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
import id.kotlin.sample.anko.ext.hasSelfPermissions
import org.jetbrains.anko.design.snackbar
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

        val permissions = arrayOf(
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS
        )
        when {
            hasSelfPermissions(permissions) -> ActivityCompat.requestPermissions(this, permissions, CallersConfigs.GRANT_ALL_PERMISSIONS)
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

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        val rootView = find<CoordinatorLayout>(R.id.container_callers)
        when (requestCode) {
            CallersConfigs.GRANT_ALL_PERMISSIONS -> when {
                grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED -> snackbar(rootView, resources.getString(R.string.message_permissions_granted)).show()
                else -> snackbar(rootView, resources.getString(R.string.message_permissions_denied)).show()
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
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