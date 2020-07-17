package com.amp.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.view_pager_layout.view.*

class LayoutViewPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var dotsColor: Int = R.attr.colorPrimary
    private var dotsStrokeColor: Int = R.attr.colorPrimary
    private var currentPageListener: CurrentPageListener? = null

    init {
        inflateLayout()
        var enableDots = true
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.LayoutViewPager, 0, 0)
            dotsColor = a.getColor(R.styleable.LayoutViewPager_dotsColor, dotsColor)
            dotsStrokeColor =
                a.getColor(R.styleable.LayoutViewPager_dotsStrokeColor, dotsStrokeColor)
            enableDots = a.getBoolean(R.styleable.LayoutViewPager_enableDots, true)
            a.recycle()
        }
        if (enableDots)
            worm_dots_indicator.visibility = View.VISIBLE
        else worm_dots_indicator.visibility = View.GONE
        worm_dots_indicator.setDotIndicatorColor(dotsColor)
        worm_dots_indicator.setStrokeDotsIndicatorColor(dotsStrokeColor)
    }

    private fun inflateLayout() {
        LayoutInflater.from(context)
            .inflate(R.layout.view_pager_layout, this, true)
    }

    fun setLayouts(layouts: List<Int>) {
        if (layouts.isNullOrEmpty())
            throw IllegalArgumentException("The list must not be null or empty!")

        layout_view_pager_view.adapter = ViewPagerAdapter(context, layouts)
        if (worm_dots_indicator.visibility == View.VISIBLE)
            worm_dots_indicator.setViewPager(layout_view_pager_view)

        layout_view_pager_view.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (currentPageListener != null)
                    currentPageListener!!.currentPageDisplayed(position)
            }

        })
    }

    fun setCurrentPageListener(currentPageListener: CurrentPageListener) {
        this.currentPageListener = currentPageListener
    }

    fun enableDotsIndicator(flag: Boolean) {
        if (flag)
            worm_dots_indicator.visibility = View.VISIBLE
        else worm_dots_indicator.visibility = View.GONE
    }
}