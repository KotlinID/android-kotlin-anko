package id.kotlin.sample.anko.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.basic.FirstActivity
import id.kotlin.sample.anko.basic.FirstExtraActivity
import id.kotlin.sample.anko.dsl.HomeUI
import id.kotlin.sample.anko.home.HomeAdapter.HomeListener
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity(), HomeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeUI().setContentView(this)

        val toolbar = find<Toolbar>(R.id.toolbar_home)
        toolbar.title = title
        setSupportActionBar(toolbar)

        val recyclerView = find<RecyclerView>(R.id.rv_home)
        val layoutManager = LinearLayoutManager(this)
        val models: MutableList<HomeModel> = arrayListOf()
        resources.getStringArray(R.array.menu).map {
            val model = HomeModel(it)
            models.add(model)
        }

        val adapter = HomeAdapter(this, models.toList())
        recyclerView.layoutManager = layoutManager
        recyclerView.smoothScrollToPosition(recyclerView.bottom)
        recyclerView.adapter = adapter
    }

    override fun onMenuClick(position: Int) {
        when (position) {
            HomeConfigs.MENU_BASIC_INTENT -> startActivity<FirstActivity>()
            HomeConfigs.MENU_BASIC_INTENT_EXTRA -> startActivity<FirstExtraActivity>()
        }
    }
}