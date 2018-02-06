package id.kotlin.sample.anko.dsl

import android.support.v4.content.ContextCompat
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.coroutine.CoroutinesActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.alignParentTop
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.below
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.wrapContent

class CoroutinesUI : AnkoComponent<CoroutinesActivity> {

    override fun createView(ui: AnkoContext<CoroutinesActivity>) = with(ui) {
        coordinatorLayout {
            id = R.id.container_coroutines
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                toolbar {
                    id = R.id.toolbar_coroutines
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                    elevation = dip(4).toFloat()
                    setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                }.lparams {
                    alignParentTop()
                    width = matchParent
                    height = wrapContent
                }

                recyclerView {
                    id = R.id.rv_coroutines
                }.lparams { below(R.id.toolbar_coroutines) }
            }
        }
    }
}