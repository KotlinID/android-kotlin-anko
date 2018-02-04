package id.kotlin.sample.anko.basic.callers

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.basic.callers.CallersAdapter.CallersViewHolder
import id.kotlin.sample.anko.dsl.CallersItemUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class CallersAdapter(private val listener: CallersListener,
                     private val models: List<CallersModel>) : Adapter<CallersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallersViewHolder {
        val ui = AnkoContext.create(parent.context, parent)
        val view = CallersItemUI().createView(ui)

        return CallersViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CallersViewHolder, position: Int) {
        val model = models[holder.adapterPosition]
        holder.bindView(model)
    }

    override fun getItemCount(): Int = models.size

    inner class CallersViewHolder(itemView: View,
                                  private val listener: CallersListener) : ViewHolder(itemView) {

        fun bindView(model: CallersModel) {
            with(model) {
                val textView = itemView.find<TextView>(R.id.tv_callers)
                textView.text = type

                val rootView = itemView.find<RelativeLayout>(R.id.container_callers)
                rootView.setOnClickListener { listener.onTypeClick(adapterPosition) }
            }
        }
    }

    interface CallersListener {

        fun onTypeClick(position: Int)
    }
}