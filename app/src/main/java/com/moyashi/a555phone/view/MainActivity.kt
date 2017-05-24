package com.moyashi.a555phone.view

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.widget.TextView
import com.moyashi.a555phone.R
import com.moyashi.a555phone.contract.MainPresenterContract
import com.moyashi.a555phone.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainPresenterContract {
    lateinit var mainPresenter: MainActivityPresenter
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = MainActivityPresenter(this, this)
        textView = findViewById(R.id.input_num) as TextView
        textView.typeface = Typeface.createFromAsset(assets, "sharp.ttf")
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.open()
    }

    override fun setText(str: String) {
        textView.text = str
    }


    override fun dispatchKeyEvent(e: KeyEvent): Boolean {
        mainPresenter.push(e.keyCode)
        return super.dispatchKeyEvent(e)
    }
}
