package com.moyashi.a555phone.data

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack

object AudioSetting{
    private val SAMPLING_RATE = 96000

    private fun getBufSize() : Int {
        return AudioTrack.getMinBufferSize(
                SAMPLING_RATE,
                AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT)
    }

    fun getAudioTrack() : AudioTrack {
        return AudioTrack(
                AudioManager.STREAM_MUSIC, SAMPLING_RATE, AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT, getBufSize(), AudioTrack.MODE_STREAM)
    }

}
