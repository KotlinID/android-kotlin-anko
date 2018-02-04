package id.kotlin.sample.anko.home

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.dsl.HomeItemUI
import id.kotlin.sample.anko.home.HomeAdapter.HomeViewHolder
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class HomeAdapter(private val listener: HomeListener,
                  private val models: List<HomeModel>) : Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val ui = AnkoContext.create(parent.context, parent)
        val view = HomeItemUI().createView(ui)

        return HomeViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val model = models[holder.adapterPosition]
        holder.bindView(model)
    }

    override fun getItemCount(): Int = models.size

    inner class HomeViewHolder(itemView: View,
                               private val listener: HomeListener) : ViewHolder(itemView) {

        fun bindView(model: HomeModel) {
            with(model) {
                val textView = itemView.find<TextView>(R.id.tv_home)
                textView.text = menu

                val rootView = itemView.find<RelativeLayout>(R.id.container_home)
                rootView.setOnClickListener { listener.onMenuClick(adapterPosition) }
            }
        }
    }

    interface HomeListener {

        fun onMenuClick(position: Int)
    }
}