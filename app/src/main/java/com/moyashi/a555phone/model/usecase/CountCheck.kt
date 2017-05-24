package com.moyashi.a555phone.model.usecase

import com.moyashi.a555phone.R

object CountCheck {
    private var count = 0

    internal fun getPushResource() : Int {
        if (count == 3) {
            count = 0
        }
        count++
        when (count){
            1 -> return R.raw.push1
            2 -> return R.raw.push2
            else -> return R.raw.push3
        }
    }

    internal fun onResetCount(){
        count = 0
    }
}
