package id.kotlin.sample.anko.coroutine

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.coroutine.CoroutinesAdapter.CoroutinesViewHolder
import id.kotlin.sample.anko.dsl.CoroutinesItemUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class CoroutinesAdapter(private val listener: CoroutinesListener,
                        private val models: List<CoroutinesModel>) : Adapter<CoroutinesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoroutinesViewHolder {
        val ui = AnkoContext.create(parent.context, parent)
        val view = CoroutinesItemUI().createView(ui)

        return CoroutinesViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CoroutinesViewHolder, position: Int) {
        val model = models[holder.adapterPosition]
        holder.bindView(model)
    }

    override fun getItemCount(): Int = models.size

    inner class CoroutinesViewHolder(itemView: View,
                                     private val listener: CoroutinesListener) : ViewHolder(itemView) {

        fun bindView(model: CoroutinesModel) {
            with(model) {
                val textView = itemView.find<TextView>(R.id.tv_coroutines)
                textView.text = coroutine

                val rootView = itemView.find<RelativeLayout>(R.id.container_coroutines_item)
                rootView.setOnClickListener { listener.onCoroutineClick(adapterPosition) }
            }
        }
    }

    interface CoroutinesListener {

        fun onCoroutineClick(position: Int)
    }
}