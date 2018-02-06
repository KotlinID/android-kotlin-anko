package id.kotlin.sample.anko.dsl

import android.support.v4.content.ContextCompat
import android.widget.TextView
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.db.DBResultActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.alignParentTop
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.applyRecursively
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.below
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.scrollView
import org.jetbrains.anko.textColor
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

class DBResultUI : AnkoComponent<DBResultActivity> {

    override fun createView(ui: AnkoContext<DBResultActivity>) = with(ui) {
        coordinatorLayout {
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                toolbar {
                    id = R.id.toolbar_db_result
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                    elevation = dip(4).toFloat()
                    setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                }.lparams {
                    alignParentTop()
                    width = matchParent
                    height = wrapContent
                }

                scrollView {
                    isFillViewport = true

                    verticalLayout {
                        textView {
                            id = R.id.tv_name
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                            topMargin = dip(8)
                            marginEnd = dip(16)
                            marginStart = dip(16)
                        }

                        textView {
                            id = R.id.tv_age
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                            topMargin = dip(8)
                            marginEnd = dip(16)
                            marginStart = dip(16)
                        }

                        textView {
                            id = R.id.tv_occupation
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                            topMargin = dip(8)
                            marginEnd = dip(16)
                            marginStart = dip(16)
                        }
                    }.applyRecursively { view ->
                        when (view) {
                            is TextView -> {
                                view.textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                                view.textSize = 16f
                            }
                        }
                    }
                }.lparams {
                    below(R.id.toolbar_db_result)
                    width = matchParent
                    height = matchParent
                }
            }
        }
    }
}