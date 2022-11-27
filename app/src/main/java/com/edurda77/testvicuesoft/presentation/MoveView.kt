package com.edurda77.testvicuesoft.presentation

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View

class MoveView(private val borders: View) {

    private var rightDX = 0F
    private var rightDY = 0F

    @SuppressLint("ClickableViewAccessibility")
    fun moveItem(item: View) {
        item.setOnTouchListener { view, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    rightDX = view!!.x - event.rawX
                    rightDY = view.y - event.rawY
                }
                MotionEvent.ACTION_MOVE -> {
                    view!!.animate()
                        .x(
                            calcMoveDepDimens(
                                axisSizeView = borders.width,
                                eventRawAxis = event.rawX,
                                deltaMoveAxis = rightDX,
                                axisSizeMovedView = item.width
                            )
                        )
                        .y(
                            calcMoveDepDimens(
                                axisSizeView = borders.height,
                                eventRawAxis = event.rawY,
                                deltaMoveAxis = rightDY,
                                axisSizeMovedView = item.height
                            )
                        )
                        .setDuration(0)
                        .start()
                }
                else -> {
                    return@setOnTouchListener false
                }
            }
            true
        }
    }

    private fun calcMoveDepDimens(
        axisSizeView: Int,
        eventRawAxis: Float,
        deltaMoveAxis: Float,
        axisSizeMovedView: Int
    ): Float {
        val axialDisplacement = if ((eventRawAxis + deltaMoveAxis) < 0) {
            0F
        } else if ((eventRawAxis + deltaMoveAxis + axisSizeMovedView) > axisSizeView) {
            (axisSizeView - axisSizeMovedView).toFloat()
        } else {
            eventRawAxis + deltaMoveAxis
        }
        return axialDisplacement
    }
}