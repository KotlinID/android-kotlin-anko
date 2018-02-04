package id.kotlin.sample.anko.dsl

import android.support.v4.content.ContextCompat
import android.view.Gravity
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.basic.SecondActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.alignParentTop
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.centerInParent
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textColor
import org.jetbrains.anko.textView
import org.jetbrains.anko.wrapContent

class SecondUI : AnkoComponent<SecondActivity> {

    override fun createView(ui: AnkoContext<SecondActivity>) = with(ui) {
        coordinatorLayout {
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                toolbar {
                    id = R.id.toolbar_second
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                    elevation = dip(4).toFloat()
                    setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                }.lparams {
                    alignParentTop()
                    width = matchParent
                    height = wrapContent
                }

                textView {
                    id = R.id.tv_second
                    text = ctx.resources.getString(R.string.text_second)
                    textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                    textSize = 16f
                    gravity = Gravity.CENTER
                }.lparams {
                    centerInParent()
                    width = matchParent
                    height = matchParent
                }
            }
        }
    }
}