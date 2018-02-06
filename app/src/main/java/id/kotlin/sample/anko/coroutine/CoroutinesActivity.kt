package id.kotlin.sample.anko.coroutine

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.coroutine.CoroutinesAdapter.CoroutinesListener
import id.kotlin.sample.anko.dsl.CoroutinesUI
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class CoroutinesActivity : AppCompatActivity(), CoroutinesListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutinesUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_coroutines)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        setSupportActionBar(toolbar)

        val recyclerView = find<RecyclerView>(R.id.rv_coroutines)
        val layoutManager = LinearLayoutManager(this)
        val models: MutableList<CoroutinesModel> = arrayListOf()
        resources.getStringArray(R.array.coroutines).map {
            val model = CoroutinesModel(it)
            models.add(model)
        }

        val adapter = CoroutinesAdapter(this, models)
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

    override fun onCoroutineClick(position: Int) {
        val rootView = find<CoordinatorLayout>(R.id.container_coroutines)
        when (position) {
            CoroutinesConfigs.COROUTINE_REFERENCE -> {}
            CoroutinesConfigs.COROUTINE_BACKGROUND -> {}
        }
    }
}