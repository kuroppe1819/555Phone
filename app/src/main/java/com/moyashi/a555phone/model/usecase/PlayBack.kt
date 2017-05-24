package com.moyashi.a555phone.model.usecase

import android.app.Activity
import android.util.Log
import com.moyashi.a555phone.data.AudioSetting
import com.moyashi.a555phone.data.ChoiceMusic
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.io.IOException

class PlayBack(private val activity: Activity) {
    private val TAG = javaClass.simpleName

    private fun getAudioObservable(key : Int): Observable<Int> {
        return Observable.create<Int> { subscriber ->
            try {
                val resource = ChoiceMusic.getRawResource(key)
                playMusic(resource)
                subscriber.onComplete()
            } catch (e: IOException) {
                subscriber.onError(e)
            }
        }
    }

    fun onStart(key: Int) {
        getAudioObservable(key).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.single())
                .subscribe(object : Observer<Int> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(resource: Int) {

                    }

                    override fun onError(e: Throwable) {
                        Log.e(TAG, e.toString())
                    }

                    override fun onComplete() {

                    }
                })
    }

    private fun playMusic(resource: Int) {
        try {
            val input = activity.resources.openRawResource(resource)
            val wavData = ByteArray(input.available())
            input.read(wavData)
            input.close()

            val audioTrack = AudioSetting.getAudioTrack()
            // 再生
            audioTrack.play()
            // ヘッダ44byteをオミット
            audioTrack.write(wavData, 44, wavData.size - 300)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
