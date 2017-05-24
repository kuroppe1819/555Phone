package com.moyashi.a555phone.presenter

import android.app.Activity
import com.moyashi.a555phone.contract.MainPresenterContract
import com.moyashi.a555phone.model.entity.ActionCodeEntity
import com.moyashi.a555phone.model.entity.KeyEntity
import com.moyashi.a555phone.model.usecase.CountCheck
import com.moyashi.a555phone.model.usecase.PlayBack
import com.moyashi.a555phone.util.KeyConvertUtil

class MainActivityPresenter(private val listener: MainPresenterContract, activity: Activity) {
    private val playBack: PlayBack = PlayBack(activity)
    private var pushCount = 0

    fun push(key: Int) {
        pushCount++
        if (pushCount % 2 == 0) {
            playBack.onStart(key)
            if (key == KeyEntity.ENTER) {
                onActionPlayBack()
            } else {
                KeyConvertUtil.setInputNumber(key)
                listener.setText(KeyConvertUtil.getInputNumber())
            }
            pushCount = 0
        }
    }

    fun open() {
        playBack.onStart(ActionCodeEntity.OPEN)
    }

    private fun onActionPlayBack() {
        val num = KeyConvertUtil.getInputNumber()
        if (num.isEmpty()) {
            playBack.onStart(ActionCodeEntity.ERROR)
        } else {
            when (num.toInt()) {
                ActionCodeEntity.TRANSFORM -> playBack.onStart(ActionCodeEntity.TRANSFORM)
                ActionCodeEntity.BURSTMODE -> playBack.onStart(ActionCodeEntity.BURSTMODE)
                else -> playBack.onStart(ActionCodeEntity.ERROR)
            }
        }
        CountCheck.onResetCount()
        KeyConvertUtil.clearInputNumber()
    }

}
