package id.kotlin.sample.anko.basic.actions

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.basic.actions.ActionsAdapter.ActionsListener
import id.kotlin.sample.anko.dsl.ActionsUI
import org.jetbrains.anko.alert
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.find
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.longToast
import org.jetbrains.anko.noButton
import org.jetbrains.anko.selector
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class ActionsActivity : AppCompatActivity(), ActionsListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActionsUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_actions)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val recyclerView = find<RecyclerView>(R.id.rv_actions)
        val layoutManager = LinearLayoutManager(this)
        val models: MutableList<ActionsModel> = arrayListOf()
        resources.getStringArray(R.array.actions).map {
            val model = ActionsModel(it)
            models.add(model)
        }

        val adapter = ActionsAdapter(this, models)
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

    override fun onActionClick(position: Int) {
        val rootView = find<CoordinatorLayout>(R.id.container_actions)
        when (position) {
            ActionsConfigs.ACTION_TOAST -> toast(R.string.message_toast)
            ActionsConfigs.ACTION_TOAST_LONG -> longToast(R.string.message_toast_long)
            ActionsConfigs.ACTION_SNACKBAR -> snackbar(rootView, R.string.message_snackbar)
            ActionsConfigs.ACTION_SNACKBAR_LONG -> longSnackbar(rootView, R.string.message_snackbar_long)
            ActionsConfigs.ACTION_ALERT -> {
                alert(R.string.message_question) {
                    yesButton { snackbar(rootView, R.string.message_yes) }
                    noButton { longSnackbar(rootView, R.string.message_no) }
                }.show()
            }
            ActionsConfigs.ACTION_SELECTOR -> {
                val gender = resources.getStringArray(R.array.gender).toList()
                selector(resources.getString(R.string.message_gender), gender, { _, which ->
                    toast(resources.getString(R.string.message_selector, gender[which]))
                })
            }
            ActionsConfigs.ACTION_PROGRESS_DIALOG -> indeterminateProgressDialog(R.string.message_progress_desc, R.string.message_progress_title).show()
        }
    }
}