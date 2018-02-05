package id.kotlin.sample.anko.dsl

import android.support.v4.content.ContextCompat
import android.text.InputType
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import id.kotlin.sample.anko.R
import id.kotlin.sample.anko.basic.callers.type.ShareActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.above
import org.jetbrains.anko.alignParentBottom
import org.jetbrains.anko.alignParentTop
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.applyRecursively
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.below
import org.jetbrains.anko.bottomPadding
import org.jetbrains.anko.button
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.editText
import org.jetbrains.anko.hintTextColor
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.scrollView
import org.jetbrains.anko.textColor
import org.jetbrains.anko.topPadding
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

class ShareUI : AnkoComponent<ShareActivity> {

    override fun createView(ui: AnkoContext<ShareActivity>) = with(ui) {
        coordinatorLayout {
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                toolbar {
                    id = R.id.toolbar_share
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
                        editText {
                            id = R.id.et_subject
                            hint = ctx.resources.getString(R.string.hint_subject)
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                            topMargin = dip(8)
                            marginEnd = dip(16)
                            marginStart = dip(16)
                        }

                        editText {
                            id = R.id.et_message
                            hint = ctx.resources.getString(R.string.hint_message)
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                            topMargin = dip(8)
                            marginEnd = dip(16)
                            marginStart = dip(16)
                        }
                    }.applyRecursively { view ->
                        when (view) {
                            is EditText -> {
                                view.hintTextColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                                view.textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                                view.textSize = 16f
                                view.isCursorVisible = false
                                view.imeOptions = EditorInfo.IME_ACTION_DONE
                                view.inputType = InputType.TYPE_CLASS_TEXT
                            }
                        }
                    }
                }.lparams {
                    below(R.id.toolbar_share)
                    above(R.id.btn_share)
                    width = matchParent
                    height = matchParent
                }

                button {
                    id = R.id.btn_share
                    text = ctx.resources.getString(R.string.btn_share)
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