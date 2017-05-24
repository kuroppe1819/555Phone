package com.moyashi.a555phone.data

import com.moyashi.a555phone.R
import com.moyashi.a555phone.model.entity.ActionCodeEntity
import com.moyashi.a555phone.model.entity.KeyEntity
import com.moyashi.a555phone.model.usecase.CountCheck.getPushResource

object ChoiceMusic{
    fun getRawResource(key: Int): Int {
        when (key) {
            KeyEntity.NUMBER1 -> return getPushResource()
            KeyEntity.NUMBER2 -> return getPushResource()
            KeyEntity.NUMBER3 -> return getPushResource()
            KeyEntity.NUMBER4 -> return getPushResource()
            KeyEntity.NUMBER5 -> return getPushResource()
            KeyEntity.NUMBER6 -> return getPushResource()
            KeyEntity.NUMBER7 -> return getPushResource()
            KeyEntity.NUMBER8 -> return getPushResource()
            KeyEntity.NUMBER9 -> return getPushResource()
            KeyEntity.NUMBER0 -> return getPushResource()
            KeyEntity.PHONE -> return R.raw.exceedchange
            KeyEntity.ENTER -> return R.raw.enter
            ActionCodeEntity.OPEN -> return R.raw.open
            ActionCodeEntity.TRANSFORM -> return R.raw.transform
            ActionCodeEntity.ERROR -> return R.raw.error
            ActionCodeEntity.BURSTMODE -> return R.raw.burstmode
            else -> return R.raw.enter
        }
    }
}
