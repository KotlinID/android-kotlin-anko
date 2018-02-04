package id.kotlin.sample.anko.dsl

import android.support.v4.content.ContextCompat
import android.view.Gravity
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.basic.FirstActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.alignParentBottom
import org.jetbrains.anko.alignParentTop
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.below
import org.jetbrains.anko.bottomPadding
import org.jetbrains.anko.button
import org.jetbrains.anko.centerInParent
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textColor
import org.jetbrains.anko.textView
import org.jetbrains.anko.topPadding
import org.jetbrains.anko.wrapContent

class FirstUI : AnkoComponent<FirstActivity> {

    override fun createView(ui: AnkoContext<FirstActivity>) = with(ui) {
        coordinatorLayout {
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                toolbar {
                    id = R.id.toolbar_first
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                    elevation = dip(4).toFloat()
                    setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                }.lparams {
                    alignParentTop()
                    width = matchParent
                    height = wrapContent
                }

                textView {
                    id = R.id.tv_first
                    text = ctx.resources.getString(R.string.text_first)
                    textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                    textSize = 16f
                    gravity = Gravity.CENTER
                }.lparams {
                    below(R.id.toolbar_first)
                    centerInParent()
                    width = matchParent
                    height = wrapContent
                }

                button {
                    id = R.id.btn_next
                    text = ctx.resources.getString(R.string.btn_next)
                    textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                    textSize = 16f
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    topPadding = dip(16)
                    bottomPadding = dip(16)
                }.lparams {
                    alignParentBottom()
                    width = matchParent
                    height = wrapContent
                    marginEnd = dip(16)
                    marginStart = dip(16)
                    bottomPadding = dip(8)
                }
            }
        }
    }
}