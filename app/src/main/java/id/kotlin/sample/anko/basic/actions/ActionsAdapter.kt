package id.kotlin.sample.anko.basic.actions

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.basic.actions.ActionsAdapter.ActionsViewHolder
import id.kotlin.sample.anko.dsl.ActionsItemUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class ActionsAdapter(private val listener: ActionsListener,
                     private val models: List<ActionsModel>) : Adapter<ActionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionsViewHolder {
        val ui = AnkoContext.create(parent.context, parent)
        val view = ActionsItemUI().createView(ui)

        return ActionsViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ActionsViewHolder, position: Int) {
        val model = models[holder.adapterPosition]
        holder.bindView(model)
    }

    override fun getItemCount(): Int = models.size

    inner class ActionsViewHolder(itemView: View,
                                  private val listener: ActionsListener) : ViewHolder(itemView) {

        fun bindView(model: ActionsModel) {
            with(model) {
                val textView = itemView.find<TextView>(R.id.tv_actions)
                textView.text = action

                val rootView = itemView.find<RelativeLayout>(R.id.container_actions_item)
                rootView.setOnClickListener { listener.onActionClick(adapterPosition) }
            }
        }
    }

    interface ActionsListener {

        fun onActionClick(position: Int)
    }
}