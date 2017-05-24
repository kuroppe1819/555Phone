package com.moyashi.a555phone.util

import com.moyashi.a555phone.model.entity.KeyEntity

object KeyConvertUtil {
    private var stack: String = ""

    fun setInputNumber(key: Int) {
        when (key) {
            KeyEntity.NUMBER1 -> stack += "1"
            KeyEntity.NUMBER2 -> stack += "2"
            KeyEntity.NUMBER3 -> stack += "3"
            KeyEntity.NUMBER4 -> stack += "4"
            KeyEntity.NUMBER5 -> stack += "5"
            KeyEntity.NUMBER6 -> stack += "6"
            KeyEntity.NUMBER7 -> stack += "7"
            KeyEntity.NUMBER8 -> stack += "8"
            KeyEntity.NUMBER9 -> stack += "9"
            KeyEntity.NUMBER0 -> stack += "0"
        }
    }

    fun getInputNumber(): String {
        if (stack.isEmpty() || stack.length > 3){
            return ""
        }else{
            return stack
        }
    }

    fun clearInputNumber() {
        stack = ""
    }
}
