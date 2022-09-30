package com.codetron.activityfragmentlistener

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), NotifyListener {

    private lateinit var textResult: TextView
    private var notifyListener: NotifyListener? = null
    private val mainModel = MainModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.text_result)

        findViewById<Button>(R.id.button_add).setOnClickListener {
            notifyListener?.notifyResult(mainModel.randomizeChar())
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment())
                .commitAllowingStateLoss()
        }

        supportFragmentManager.addFragmentOnAttachListener { _, fragment ->
            if (fragment is NotifyListener) {
                notifyListener = fragment
            }
        }

    }

    override fun notifyResult(result: String) {
        textResult.text = result
    }
}